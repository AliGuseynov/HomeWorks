package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MainThread {
  public static void foo() {
      try (InputStream in = new FileInputStream(new File("C:\\Users\\nihad\\Desktop\\task.txt")); InputStreamReader r = new InputStreamReader(in); BufferedReader bf = new BufferedReader(r)) {
          String line = null;
          String result = "";
          while ((line = bf.readLine()) != null) {
              Thread thread=new Thread();
              System.out.println(thread.currentThread().getName());
              result += line + "\n";
              thread.start();

          }
          System.out.println(result);
      } catch (IOException e) {
          throw new RuntimeException(e);
      }
  }
    public  static  void taskCallable() throws IOException, InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\nihad\\Desktop\\pdfyecevirir.txt"));
        List<Future> futures = new ArrayList<>();
        String line;
        Callable<Integer> callable = null;
        while ((line = reader.readLine()) != null) {
            final String tempLine = line;
            callable = new Callable() {
                @Override
                public Integer call() throws Exception {
                    return tempLine.split(" ").length;
                }
            };

            try {
                callable.call();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            Future<Integer> future = executorService.submit(callable);
            futures.add(future);
        }
        Integer sum=0;
        for (Future<Integer> future1:futures
        ) {
            sum+=future1.get();

        }
        System.out.println(sum);
        executorService.shutdown();

    }
}
