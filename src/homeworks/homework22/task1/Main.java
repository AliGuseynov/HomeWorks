package homeworks.homework22.task1;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        Base base = new Base();
        base.readFile("Test.txt");
        System.out.println(base.getCarNumbersList());
        System.out.println(base.getDateTimeList());
        System.out.println(base.getIntList());
        System.out.println(base.getStringList());

        base.writeFile();
    }
}

