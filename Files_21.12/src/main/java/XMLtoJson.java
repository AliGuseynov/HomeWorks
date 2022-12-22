import org.json.*;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.Scanner;
import java.util.stream.Collectors;

class XMLtoJson {
    private static String XMLlocation;


    public static void convert(){

        // loading file location from config
        XMLlocation = loadProperties("XMLLocation");
//        System.out.println(XMLlocation);

        // getting xml file
        String XMLin = getXML(XMLlocation);
//        System.out.println(XMLin);


        //parsing
        String jsonString = parseXML(XMLin);

        //
        writeToJson(jsonString);

    }


    public static String loadProperties(String property){
        try (InputStream input = new FileInputStream("files\\system\\config.test")) {
            Properties prop = new Properties();
            prop.load(input);

            return prop.getProperty(property);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }


    private static String getXML(String location){

        try {
            BufferedReader reader = new BufferedReader(new FileReader(location));
            String textOut = reader.lines().collect(Collectors.joining("\n"));
            reader.close();
            return textOut;
        } catch (IOException e) {
            System.out.println("Can't get XML");
            return null;
        }
    }

    private static String parseXML(String input){
        try {
            JSONObject json = XML.toJSONObject(input);
            return json.toString(4);

        }catch (JSONException e) {
            System.out.println(e.toString());
        }
        return null;
    }

    private static void writeToJson(String input){
        try {
            FileWriter myWriter = new FileWriter("files\\xml\\jsonOut.json");
            myWriter.write(input);
            myWriter.flush();
            myWriter.close();
            System.out.println("Write success");
        } catch (IOException e) {
            System.out.println("Writing error");
        }
    }


}

