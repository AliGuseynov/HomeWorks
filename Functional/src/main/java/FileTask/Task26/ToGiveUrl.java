package FileTask.Task26;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class ToGiveUrl {
    public static void main(String[] args) throws IOException {

        for (String link : findLinks("https://code.edu.az/")) {
            System.out.println(link);
        }

    }

    private static Set<String> findLinks(String url) throws IOException {

        Set<String> links = new HashSet<>();

        Document doc = Jsoup.connect(url).get();

        Elements elements = doc.select("a[href]");
        for (Element element : elements) {
            links.add(element.attr("href"));
        }

        return links;

    }
}