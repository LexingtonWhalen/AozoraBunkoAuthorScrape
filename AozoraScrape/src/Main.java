/**
 * Written by Lex Whalen
 */


import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException{
        String[] URLArr = {"https://www.aozora.gr.jp/index_pages/person148.html",
    "https://www.aozora.gr.jp/index_pages/person35.html","https://www.aozora.gr.jp/index_pages/person81.html"};
        
    AuthorManager manager = new AuthorManager(URLArr);
    manager.createIndividualCSVs();

    manager.createMassiveCSV();


    //manager.summary();


    /*
    *Note, can also create CSVs / summaries for individual authors
    */

    //Author author = new Author(URLArr[0]);
    //author.createCSV();
    //author.summary();
    }
}