package org.example;

import org.json.JSONObject;
import org.json.XML;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static String readFile(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));

        return new String(encoded, encoding);
    }

    public static JSONObject convertToJson(String content) throws IOException {
        JSONObject json = XML.toJSONObject(content);
        writeToJsonFile(json);
        return json;
    }

    public static void writeToJsonFile(JSONObject json) throws IOException {
        FileWriter file = new FileWriter("output.json");
        file.write(json.toString());
        file.close();
    }

    public static void main(String[] args) {
        String filePath = "test.xml";

        String content = null;
        try {
            content = readFile(filePath, StandardCharsets.UTF_8);
            convertToJson(content);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(content);
    }
}