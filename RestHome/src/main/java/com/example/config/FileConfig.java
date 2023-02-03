package com.example.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Slf4j
public class FileConfig {

    private static List<String> readFile(String fileName)  {
        List<String> strings = new ArrayList<>();
        try {
            FileInputStream fileInputStream=new FileInputStream(fileName);
            Scanner scanner = new Scanner(fileInputStream);
            while (scanner.hasNextLine()){
                strings.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            log.error("FILE DID NOT FOUND");
        }
        return strings;

    }

    public static List<UserDetails> convertToUser(String fileName){
        //admin,$2a$10$0bXqBzZFwi14TGkDrLDIt.yCkgAWvhKSkU8e.bzgCI8NNm0IIA9Ie,true,ADMIN
        List<UserDetails> result = new ArrayList<>();
        for (String s : readFile(fileName)){
            String[] arr = s.split(",");

            result.add(User.builder()
                    .username(arr[0])
                    .password(arr[1])
                    .roles(arr[3]).build());
        }
        return result;
    }

}
