/**
 * Written by Lex Whalen
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//jsoup
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

//regex
import java.util.regex.*;

//example url:https://www.aozora.gr.jp/index_pages/person35.html

public class Author extends Scraper{

    private String authorName;

    private Pattern authorPattern = Pattern.compile("(?<=作家別作品リスト：).*");
    //gets the urls to the books of his
    private Pattern bookPattern = Pattern.compile("(https://www.aozora.gr.jp/cards/).*");

    private ArrayList<String> titlesURLsArr = new ArrayList<>(); //list of titles of books
    
    private ArrayList<Work> worksArr = new ArrayList<>(); //lists of Work objects, which are the individual works

    //holds an array of arrays of [token,pos]
    private List<Pair<String,String>> masterTokenPOSArr = new ArrayList<>();

    public Author(String rootURL) throws IOException
    {
        super(rootURL);
        //get name of author
        Matcher authorMatcher = this.authorPattern.matcher(this.rootDoc.title());
        while(authorMatcher.find())
        {
            this.authorName = authorMatcher.group(0);
        }

        initiateAuthor();
    }

    private void initiateAuthor() throws IOException
    {
        scrapeBookURLs();

        for(int i = 0; i< this.titlesURLsArr.size();i++)
        {
            //create the work object
            Work work = new Work(this.titlesURLsArr.get(i));
            worksArr.add(work);
        }

        //get the token arrays
        getWorksTokenPOSArr();
    }

    private void getWorksTokenPOSArr()
    {
        //gets all of the tokenPOSArr's from each work
        for(Work work: this.worksArr)
        {
            for(Pair<String,String> pair:work.getTokenPOSArr())
            {
                this.masterTokenPOSArr.add(pair);
            }
        }
    }

    private void scrapeBookURLs()
    {
        //populate titlesURLs with each work of author
        Elements links = this.rootDoc.select("a");
        //<a href="../cards/000035/ only want urls that have that
        for(Element link:links)
        {
            //System.out.println(link.attr("abs:href"));
            Matcher matcher = this.bookPattern.matcher(link.attr("abs:href"));
            while(matcher.find())
            {
                this.titlesURLsArr.add(matcher.group());
            }
        }
    }

    public void createCSV()
    {
        FrequencyManager freqManager = new FrequencyManager(getMasterTokenPOSArr());
        freqManager.createCSV(getAuthorName());
    }

    public List<Pair<String,String>> getMasterTokenPOSArr()
    {
        return this.masterTokenPOSArr;
    }

    public String getAuthorName()
    {
        return this.authorName;
    }

    public int getWorkCount()
    {
        return this.worksArr.size();
    }

    public void summary() throws IOException
    {
        System.out.println("List of works by " + this.authorName + "." + 
        "\n\nThis list contains " + this.titlesURLsArr.size() + " works.\n");

        for(int i =0; i< this.worksArr.size();i++)
        {
            String workTitle = this.worksArr.get(i).getWorkTitle();
            System.out.println((i+1) + ": " + workTitle);
        }
    }
}
