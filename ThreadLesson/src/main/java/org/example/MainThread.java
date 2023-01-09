package org.example;

import java.io.*;

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
}
