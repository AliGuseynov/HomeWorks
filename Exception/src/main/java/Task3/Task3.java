package Task3;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class Task3 {
    public static void main(String[] args) {
        try(BufferedReader rd=new BufferedReader(new FileReader("C:\\Users\\user\\Documents\\nihadosi.txt"))){
            List<String> list= rd.lines().toList();
            for (String s:list){
                System.out.println(s);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
