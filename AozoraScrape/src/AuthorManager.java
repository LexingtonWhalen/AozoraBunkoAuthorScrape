
/**
 * Written by Lex Whalen
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//takes in a list of authors
public class AuthorManager {

    private Author[] authorArr;
    private String[] authorURLArr;

    public AuthorManager(String[] authorURLArr) throws IOException
    {
        this.authorURLArr = authorURLArr;
        this.authorArr = new Author[authorURLArr.length];

        //add each author to authorArr
        for(int i=0; i<this.authorURLArr.length;i++)
        {
            this.authorArr[i] = new Author(this.authorURLArr[i]);
        }
    }

    public void createIndividualCSVs()
    {
        for(int i=0; i<this.authorURLArr.length;i++)
        {
            this.authorArr[i].createCSV();
        }
    }
    public void createMassiveCSV()
    {
        List<Pair<String,String>> masterTokenPOSArr = new ArrayList<>();
        //creates one big csv of all of the tokens from each author
        for(int i = 0;i < this.authorArr.length;i++)
        {
            masterTokenPOSArr.addAll(this.authorArr[i].getMasterTokenPOSArr());
        }

        FrequencyManager freqManager = new FrequencyManager(masterTokenPOSArr);

        freqManager.createCSV("combined");
    }

    public void summary()
    {
        System.out.println("There are " + (this.authorArr.length + 1) + " authors in list.\n");

        System.out.println("The authors are: ");
        for(int i = 0; i<this.authorArr.length;i++)
        {
            System.out.println((i+1) + ": " + this.authorArr[i].getAuthorName() + ". Total works found: " +  this.authorArr[i].getWorkCount());
        }
    }

}
