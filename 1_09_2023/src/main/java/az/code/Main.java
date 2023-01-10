package az.code;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException, TimeoutException {

        File file = new File("C:\\Threads\\threads.txt");

//        Semaphore semaphore = new Semaphore(3);

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<String> result;

        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;

        while ((line = br.readLine()) != null) {

            final String tempLine = line;
//            semaphore.acquire();

//1/9/2023
            result = executorService.submit(() -> Thread.currentThread().getName() + "-" + tempLine.split(" ")
                    .length);
            String str = result.get(1, TimeUnit.SECONDS);
            System.out.println(str);


//                System.out.println(Thread.currentThread().getName() + "-" + tempLine.split(" ")
//                        .length);
//            executorService.shutdown();

//            try {
//                Thread.sleep(10000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });

//with executor
//            new Thread(() -> executorService.submit(() ->
//            {
//                System.out.println(Thread.currentThread().getName() + " "
//                        + tempLine.split(" ").length);
//                executorService.shutdown();
//
//
//                try {
//                    Thread.sleep(300);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
////                semaphore.release();
//
//            })).start();


        }


    }
}
