import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MyCallable implements Callable<Integer> {

    public static String input = "data.txt";
    public ExecutorService executorService = Executors.newFixedThreadPool(4);

    @Override
    public Integer call() throws Exception {

        List<Integer> futures = new ArrayList<>();

        try {

            BufferedReader bufferedReader = new BufferedReader(new FileReader(input));
            String line;

            while ((line = bufferedReader.readLine()) != null) {

                final String tmpLine = line;

                Callable<Integer> callable = () -> {

                    System.out.println(Thread.currentThread().getName() + " " + tmpLine.split(" ").length);
                    return tmpLine.split(" ").length;
                };

                Future<Integer> future = executorService.submit(callable);
                futures.add(future.get());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            executorService.shutdown();
        }

        return futures.stream().reduce(0, Integer::sum);
    }
}
