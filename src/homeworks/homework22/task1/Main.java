package homeworks.homework22.task1;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        FileReader file = new FileReader("D:\\Desktop\\forCode12\\forTask1.txt");
        BufferedReader bufferedReader = new BufferedReader(file);

        String line = bufferedReader.readLine();
        int i;
        while (line != null) {
//            String s = String.valueOf((char) i);
//            System.out.print(s);

//            Pattern pattern = Pattern.compile("^[0-9]*$");
//            Matcher matcher = pattern.matcher(s);
//            s.matches("^[0-9]+$");
            if (Pattern.matches("[0-9]+", line)) {
                FileWriter numberFile = new FileWriter("D:\\Desktop\\forCode12\\forNumber.txt");
                line = bufferedReader.readLine();
                numberFile.close();

                System.out.println(line);


//            } else if (Pattern.matches("[a-zA-Z]", line)) {
//                FileWriter stringFile = new FileWriter("D:\\Desktop\\forCode12\\forString.txt");
////                System.out.print(s);
//
//            }
            }
            bufferedReader.close();
            file.close();
        }


    }
}

