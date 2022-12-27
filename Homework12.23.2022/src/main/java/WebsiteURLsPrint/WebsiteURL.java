package WebsiteURLsPrint;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class WebsiteURL {
    public static void main( String[] args ){
    Document document;
        try {
        document = Jsoup.connect("https://code.edu.az/").get();

        Elements links = document.select("link[href]");

        for (Element link : links) {
            System.out.println("Link: " + link.attr("href"));
            System.out.println("Text: " + link.text());
            System.out.println("");
        }
    }
        catch (IOException e)
    {
        e.printStackTrace();
    }
    }
}