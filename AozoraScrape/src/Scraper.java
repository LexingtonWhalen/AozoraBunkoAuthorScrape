/**
 * Written by Lex Whalen
 */

import org.jsoup.nodes.Document;

import java.io.IOException;

import org.jsoup.Jsoup;

public abstract class Scraper {

    protected String rootURL;
    protected Document rootDoc;

    public Scraper(String rootURL) throws IOException
    {
        this.rootURL = rootURL;
        this.rootDoc = Jsoup.connect(rootURL).get();
    }

}
