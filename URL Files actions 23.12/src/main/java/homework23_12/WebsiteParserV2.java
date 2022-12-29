package homework23_12;

import org.jsoup.Jsoup;
import java.io.IOException;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
public class WebsiteParserV2 {


    private static int counter = 0;
    private static Set<String> linksList = new HashSet<>();

    private static int levels = 0;

    public static void parseURL(String url, int level) {


        Document document;


        try {
            //Get Document object after parsing the html from given url.
            document = Jsoup.connect(url).get();

            //Get links from document object.
            Elements links = document.select("a[href]");

            int nextLevel = level+1;
            for (Element link : links) {
                String linkS = link.attr("href");

//                System.out.println("test " + link);
                if (!linksList.contains(linkS) && linkS.contains("https://code.edu.az/")){
                    linksList.add(linkS);
                    parseURL(linkS, nextLevel);
                    System.out.println("Link " + ++counter + " : " +linkS);
                }

            }

            System.out.println("Level: " + nextLevel);

        } catch (IOException e) {

//            e.printStackTrace();
        }
    }

}
