package az.code.callable;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import java.io.*;
import java.nio.Buffer;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class WordCount {
    public static void findNumOfWords() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("example.txt"));
            int wordCount = 0;
            ExecutorService executorService = Executors.newFixedThreadPool(2);
            String eachLine;
            while((eachLine = reader.readLine()) != null){
                final String finalLine = eachLine;
                Future<Integer> future = executorService.submit(() -> finalLine.split(",").length);
                wordCount += future.get();
            }
            executorService.shutdown();
            System.out.println("Word Count: " + wordCount);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
