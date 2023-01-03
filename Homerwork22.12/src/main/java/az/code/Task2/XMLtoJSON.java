package az.code.Task2;

import org.json.JSONObject;
import org.json.XML;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class XMLtoJSON {
    public static void xmlToJson() throws IOException {
        String line = "", str = "";

        String link = "C:\\Users\\Meryam\\Homerwork22.12\\file.xml";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(link));
        while ((line = bufferedReader.readLine()) != null) {
            str += line;
        }

        JSONObject jsonObject = XML.toJSONObject(str);
        System.out.println(jsonObject);
    }
}
