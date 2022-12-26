package FileTask.Task2;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import java.io.*;

public class Xml2JSON {
    static String line="",str="";
    public static void main(String[] args) throws JSONException, IOException {
        String link = "task2.xml";
        BufferedReader br = new BufferedReader(new FileReader(link));
        while ((line = br.readLine()) != null)
        {
            str+=line;
        }
        JSONObject jsondata = XML.toJSONObject(str);
        File f=new File("task2.json");
        FileWriter bf=new FileWriter(f);
        bf.write(jsondata.toString());
        bf.flush();
        System.out.println(jsondata);
    }
}
