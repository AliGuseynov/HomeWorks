package az.code.withCallable;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MyCallable implements Callable<Integer> {


    @Override
    public Integer call() throws Exception {

        List<Integer> futures = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Threads\\threads.txt"));
            String line;

            ExecutorService executorService = Executors.newFixedThreadPool(3);
//        Future<String> result;
            futures = new ArrayList<>();


            while ((line = br.readLine()) != null) {

                final String tempLine = line;

//            result = executorService.submit(() -> Thread.currentThread().getName() + "-" + tempLine.split(" ")
//                    .length);
//            String str = result.get(1, TimeUnit.SECONDS);
//            System.out.println(str);

                Callable<Integer> callable = () -> {

                    System.out.println(Thread.currentThread().getName() + " " + tempLine.split(" ").length);
                    return tempLine.split(" ").length;
                };

                Future<Integer> future = executorService.submit(callable);
                futures.add(future.get());
                executorService.shutdown();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return futures.stream().reduce(0, Integer::sum);
    }
}

