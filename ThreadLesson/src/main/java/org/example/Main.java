package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\nihad\\Desktop\\pdfyecevirir.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            final String tempLine = line;
            executorService.submit(() -> {
                System.out.println(Thread.currentThread().getName() + "-" + tempLine.split(" ").length);
                executorService.shutdown();
                try {

                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });



        }
    }
}