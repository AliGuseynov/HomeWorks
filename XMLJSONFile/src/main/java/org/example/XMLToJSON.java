package org.example;

import org.json.JSONObject;
import org.json.XML;

import java.io.*;

public class XMLToJSON {
    public static void xmlToJson(String str,String line) throws IOException {
        String link = "C:\\Users\\nihad\\IdeaProjects\\XMLJSONFile\\student.xml";
        BufferedReader br = new BufferedReader(new FileReader(link));
        while ((line = br.readLine()) != null) {
            str += line;
        }
        JSONObject jsondata = XML.toJSONObject(str);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\nihad\\IdeaProjects\\XMLJSONFile\\student.txt"));) {
            bw.write(String.valueOf(jsondata));
            bw.close();
        }
    }
}
