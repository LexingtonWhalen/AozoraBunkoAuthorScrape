/**
 * Written by Lex Whalen
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
//regex
import java.util.regex.*;

//Jsoup
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

//kuromoji
import org.atilika.kuromoji.Token;
import org.atilika.kuromoji.Tokenizer;

public class Work extends Scraper{
    //represents each work from the author
    private String workTitle;
    private Document contentDoc;

    //url for the work
    private String workURL;

    //pattern to get work title names
    private Pattern titlePattern = Pattern.compile("(?<=図書カード：).*");
    //pattern to get the html for the work
    private Pattern workURLPattern = Pattern.compile(".*(/files/).*\\.html");

    //pattern to only get the main text of the work
    private Pattern mainTextPattern = Pattern.compile("(?<=\\<div class=\"main_text\"\\>).*(?= \\<div class=\"bibliographical_information\"\\>)",Pattern.DOTALL);

    //pattern to get just the japanese within the text
    private Pattern jPattern = Pattern.compile("[ぁ-んァ-ン一-龯]+",Pattern.DOTALL);

    //string to hold the japanese within the doc
    //use StringBuilder to make java happy
    private StringBuilder jBld = new StringBuilder();
    private String japaneseContent;
    

    //j tokenizer from kuromoji
    private Tokenizer tokenizer = Tokenizer.builder().build();

    //list of pairings of token, pos
    List<Pair<String,String>> tokenPOSArr = new ArrayList<Pair<String,String>>();

    public Work(String rootURL) throws IOException
    {
        super(rootURL);

        Matcher titleMatcher = this.titlePattern.matcher(this.rootDoc.title());
        while(titleMatcher.find())
        {

            this.workTitle = titleMatcher.group(0);
        }
        //get the japanese content, put in a large string
        getContent();
        //parse the tokens of the j content
        parseTokens();
    }

    private void getContent() throws IOException
    {
        // -> /cards/ SOMETHING /files/ SOMETHING.html   ENDS WITH HTML

        Elements links = this.rootDoc.select("a");

        for(Element link:links)
        {
            
            Matcher matcher = this.workURLPattern.matcher(link.attr("abs:href"));
            while(matcher.find())
            {
                this.workURL = matcher.group(0);
            }
        }
        //create the document of the piece of work by author
        try
        {
            this.contentDoc = Jsoup.connect(this.workURL).get();
            Matcher matcher = this.mainTextPattern.matcher(this.contentDoc.body().toString());
            while(matcher.find())
            {
    
                Matcher jMatcher = this.jPattern.matcher(matcher.group());
                
                while(jMatcher.find())
                {
                    this.jBld.append(jMatcher.group());
                }
            }
    
            this.japaneseContent = this.jBld.toString();
        }catch(Exception e)
        {
            
        }
    }

    private void parseTokens()
    {
        if(this.japaneseContent != null)
        {
            for(Token token: this.tokenizer.tokenize(this.japaneseContent))
            {
                String res = token.getBaseForm();
                String POS = token.getPartOfSpeech().split(",")[0];

                if(res !=null)
                {
                    this.tokenPOSArr.add(new Pair(res,POS));
                }
            }
        }
    }
    
    List<Pair<String,String>>getTokenPOSArr()
    {
        return this.tokenPOSArr;
    }
    public String getWorkTitle()
    {
        return this.workTitle;
    }
}
