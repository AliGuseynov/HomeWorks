package com.filetask.task3;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task3Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean status = true;
        while (status) {
            System.out.println("enter file name:");
            String fileName = scanner.nextLine();


            File file = new File("C:\\JAVA");
            if (file.isDirectory()) {
                List<File> fileList = Arrays.asList(file.listFiles()).stream()
                        .filter(a -> a.getName().contains(fileName))
                        .collect(Collectors.toList());
                System.out.println(fileList);
            }

        }
    }
}
