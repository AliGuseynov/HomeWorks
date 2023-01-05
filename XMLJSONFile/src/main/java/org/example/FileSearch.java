package org.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Properties;
import java.util.Scanner;

public class FileSearch {
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
    public static void run(){
        System.out.print("- What are you searching for? \n- ");
        Scanner scanner = new Scanner(System.in);
        search(scanner.nextLine());
    }
    public static void search(String key){
        File path = new File(loadProperties("search_folder"));
        findFiles(path, key);
        run();
    }

    public static void findFiles(File file, String key){
        if (file.isDirectory()){
            Arrays.asList(file.listFiles())
                    .stream()
                    .forEach(a-> search(a, key));
        }
    }

    private static void search(File a, String key) {
        if (a.getName().contains(key)) {
            if (a.isDirectory()){
                System.out.println("Folder : " + a);
            } else {
                System.out.println(a.getName());
            }
        }
        findFiles(a, key);

    }
}
