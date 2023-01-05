package csv;

import java.io.*;
import java.util.Arrays;

public class CSVReader {
    public static void main(String[] args) {
//        String path="C:\\Users\\user\\Desktop\\data.txt";
        String path="output.csv";
        String line="";
        try{
            BufferedReader br=new BufferedReader(new FileReader(path));
            String [] values;
            while ((line=br.readLine())!=null){
                values=line.split(",");
                for (String s:values){
                    System.out.print(s+" ");
                }
                System.out.println("");
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
