<<<<<<< HEAD
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Task2 {

    //https://www.baeldung.com/java-with-jsoup

    // 56 - 5 = 51

    public static void run() throws IOException {

        int count = 0;


        Set<String> result = new HashSet<>();

        result = findLinks("https://code.edu.az/", result);

//        for (String link : findLinks()) {
//            System.out.println(link);
//            count++;
//        }

        System.out.println(result.size());




//
//        Document doc = Jsoup.connect("https://code.edu.az/").get();
//        doc.select("p").forEach(System.out::println);

    }

    private static Set<String> findLinks(String url, Set lastSet) throws IOException {

        Set<String> links = new HashSet<>();

        Document doc = Jsoup.connect(url)
                .data("query", "Java")
                .userAgent("Mozilla")
                .cookie("auth", "token")
                .timeout(3000)
                .get();


        Elements elements = doc.select("a[href]");

        for (Element element : elements) {

            String tmpUrl = element.attr("href");

            if (tmpUrl.startsWith("https")) {

//                if (links.contains(tmpUrl))
//                    System.out.println("SAME" + tmpUrl);


                links.add(tmpUrl);
                if (!links.contains(tmpUrl)) {

                    System.out.println(tmpUrl);

                    links.addAll(findLinks(tmpUrl, links));
                }


            }



//            if (element.toString().substring(0, 5).equals("https")) {
//
//                links.add(element.absUrl("href"));
//
//            }
//            links.addAll(findLinks(element.attr("href")));
//            links.add(element.attr("href"));

        }

        for (String s : links)
            links.addAll(findLinks(s, links));

        return links;

    }
}
=======
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Task2 {

    //https://www.baeldung.com/java-with-jsoup

    // 56 - 5 = 51

    public static void run() throws IOException {

        int count = 0;


        Set<String> result = new HashSet<>();

        result = findLinks("https://code.edu.az/", result);

//        for (String link : findLinks()) {
//            System.out.println(link);
//            count++;
//        }

        System.out.println(result.size());




//
//        Document doc = Jsoup.connect("https://code.edu.az/").get();
//        doc.select("p").forEach(System.out::println);

    }

    private static Set<String> findLinks(String url, Set lastSet) throws IOException {

        Set<String> links = new HashSet<>();

        Document doc = Jsoup.connect(url)
                .data("query", "Java")
                .userAgent("Mozilla")
                .cookie("auth", "token")
                .timeout(3000)
                .get();


        Elements elements = doc.select("a[href]");

        for (Element element : elements) {

            String tmpUrl = element.attr("href");

            if (tmpUrl.startsWith("https")) {

//                if (links.contains(tmpUrl))
//                    System.out.println("SAME" + tmpUrl);


                links.add(tmpUrl);
                if (!links.contains(tmpUrl)) {

                    System.out.println(tmpUrl);

                    links.addAll(findLinks(tmpUrl, links));
                }


            }



//            if (element.toString().substring(0, 5).equals("https")) {
//
//                links.add(element.absUrl("href"));
//
//            }
//            links.addAll(findLinks(element.attr("href")));
//            links.add(element.attr("href"));

        }

        for (String s : links)
            links.addAll(findLinks(s, links));

        return links;

    }
}
>>>>>>> 493c8691dbc7be9d753c564dfaf67970b5e64e2c
