package task3;

import task2.CheckedException;

import java.io.*;

public class FileTask  {
public  static void fileRead()throws CheckedException{
    try (InputStream in = new FileInputStream(" C:\\TestTask\\String.txt"); InputStreamReader r = new InputStreamReader(in); BufferedReader bf = new BufferedReader(r)) {
        String line = null;
        String result = "";
        while ((line = bf.readLine()) != null) {
            result += line + "\n";

        }
        System.out.println(result);
    } catch (IOException e) {
        throw new CheckedException("error my with my exception");
    }
}

}
