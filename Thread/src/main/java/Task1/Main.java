package Task1;


import java.io.*;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws Exception {
        String path= "C:\\Users\\user\\Downloads\\data.txt";
        BufferedReader br=new BufferedReader(new FileReader(path));
        String line;
        int i=0;
        ExecutorService executorService= Executors.newFixedThreadPool(10);
        while ((line=br.readLine())!=null) {
            final String temp = line;
            int result=executorService.submit(() -> (Callable<Integer>) () -> temp.split("\t").length).get().call();
           i+= result;
            System.out.println(result);
        }
        System.out.println("Butun birlesmelerin sayi sayi : "+i);
        executorService.shutdown();
    }
}