package org.example;

import java.io.File;
import java.util.Arrays;
public class Main {
    private static void findFiles(File file){
        if (file.isDirectory()){
            Arrays.asList(file.listFiles())
                    .stream()
                    .forEach(a-> {
                        if (!a.isDirectory()){
                        } else {
                            if(a.getName().equals(("HomeWorks"))){
                                System.out.println(a.getName());
                            }
                            findFiles(a);
                        }
                    });
        }
    }
    public static void main(String[] args) {

   findFiles(new File("C:\\Users\\User\\Desktop\\backend"));
    }
}