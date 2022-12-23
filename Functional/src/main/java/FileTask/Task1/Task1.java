package FileTask.Task1;

import java.io.*;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) throws Exception {
        File f = new File("C:\\Users\\user\\Documents\\FileCode\\file.txt");
        Scanner s = new Scanner(f);
        File ss = new File("C:\\Users\\user\\Documents\\FileCode\\Dates.txt");
        File dd = new File("C:\\Users\\user\\Documents\\FileCode\\Strings.txt");
        File ff = new File("C:\\Users\\user\\Documents\\FileCode\\Int.txt");
        File cc = new File("C:\\Users\\user\\Documents\\FileCode\\Carnum.txt");
        int a;
        String b;
        FileWriter fileWriter = new FileWriter(ff);
        FileWriter fileWriter1 = new FileWriter(ss);
        FileWriter fileWriter2 = new FileWriter(cc);
        FileWriter fileWriter3 = new FileWriter(dd);
        try {
            while (s.hasNext()) {
                if (s.hasNextInt()) {
                    a = s.nextInt();
                    System.out.println("int: " + a);
                    fileWriter.write(Integer.toString(a));
                    fileWriter.flush();
                } else {
                    b = s.next();
                    if (b.matches("(0?[1-9]|[12][0-9]|3[01]).(0?[1-9]|1[012]).((?:19|20)[0-9][0-9])")
                            ||
                            b.matches("^(?:(?:([01]?\\d|2[0-3]):)?([0-5]?\\d):)?([0-5]?\\d)")) {
                        System.out.println("Date: " + b);
                        fileWriter1.write(b + "\n");
                        fileWriter1.flush();
                    } else if (b.matches("[0-9][0-9][A-Z][A-Z][0-9][0-9][0-9]")) {
                        System.out.println("Car Number : " + b);
                        fileWriter2.write(b);
                        fileWriter2.flush();
                    } else {
                        System.out.println("String: " + b);
                        fileWriter3.write(b + "\n");
                        fileWriter3.flush();
                    }
                }
            }
        } finally {
            s.close();
            fileWriter.close();
            fileWriter1.close();
            fileWriter2.close();
            fileWriter3.close();
        }
    }
}
