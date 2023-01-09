package classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallableClass {

    public static void read(){

        ExecutorService executorService = Executors.newFixedThreadPool(10);


        try {
            BufferedReader reader = new BufferedReader(new FileReader("files\\text.txt"));
            String line;
            List<Integer> intFutureList = new ArrayList<>();

            while ((line = reader.readLine()) != null){

                final String tempLine = line;

                Callable<Integer> callable = () -> tempLine.split(" ").length;

                intFutureList.add(executorService.submit(callable).get());
            }


              Integer resultInt = intFutureList.stream()
                      .reduce(0, Integer::sum);


            System.out.println(resultInt);
            executorService.shutdown();

        } catch (IOException | ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
