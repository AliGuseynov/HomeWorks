package org.example.file;

import org.example.exceptions.CheckedException;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {

    public static void main(String[] args) {
        try(
                BufferedReader bufferedReader = Files.newBufferedReader(Paths.get("kishi.txt"), StandardCharsets.UTF_8)

        ) {
            List<String> list = new ArrayList<>();
            String line = bufferedReader.readLine();
            while (line!=null){
                String[] elements = line.split(",");
                String name = String.valueOf(elements);
                list.add(name);
                line=bufferedReader.readLine();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
