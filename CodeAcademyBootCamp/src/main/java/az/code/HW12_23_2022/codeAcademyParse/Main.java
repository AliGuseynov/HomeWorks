package az.code.HW12_23_2022.codeAcademyParse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Document document = Jsoup.connect("https://code.edu.az/").get();
        Elements links = document.select("a[href]");

        for (Element element : links) {
            System.out.println("link:" + element.attr("href"));
            System.out.println("text:" + element.text());
        }

    }
}
