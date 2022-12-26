package org.example;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.Iterator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {
    public static void main(String[] args) throws Exception
    {
        Reader r = null;

        try {
            URL u = new URL("https://code.edu.az/");
            // URL u = new URL(args[0]);
            InputStream in = u.openStream();
            r = new InputStreamReader(in);

            Document jsoup = Jsoup.connect("https://code.edu.az/").get();
            Elements aHref = jsoup.getElementsByTag("a");
            Iterator<Element> iterator = aHref.iterator();
            while (iterator.hasNext())
            {
                Element element = iterator.next();
                System.out.println("\nLink: " + element.attr("href"));
                System.out.println("Link Name: " + element.text());
            }
        } finally {
            if (r != null) {
                r.close();
            }
        }
    }
}