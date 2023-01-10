package az.code.withCallable;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException, TimeoutException {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Threads\\threads.txt"));
        String line;

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<String> result;

//        List<Callable<String>> callables = new ArrayList<Callable<String>>();??????????????????


        while ((line = br.readLine()) != null) {

            final String tempLine = line;


            result = executorService.submit(() -> Thread.currentThread().getName() + "-" + tempLine.split(" ")
                    .length);
            String str = result.get(1, TimeUnit.SECONDS);
            System.out.println(str);


        }


    }
}
