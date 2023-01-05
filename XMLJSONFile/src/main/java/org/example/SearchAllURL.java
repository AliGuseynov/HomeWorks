package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;


public class SearchAllURL {
public static  int count=0;
    private static Set<String> linksList = new HashSet<>();


    public static void parseURL(String url, int level) {
        try {
            //Get Document object after parsing the html from given url.
            Document document = Jsoup.connect(url).ignoreContentType(true).get();

            Elements links = document.select("a[href]");

            int nextLevel = level+1;
            for (Element link : links) {
                String linkS = link.attr("href");


                if (!linksList.contains(linkS) && linkS.contains("https://code.edu.az/")){
                    linksList.add(linkS);
                    parseURL(linkS, nextLevel);
                    count++;
                    System.out.println("Link "+count+":"+linkS);
                }

            }



        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
