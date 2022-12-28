package az.code.lessonException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NameException {

        Person person = new Person();
        Scanner scanner = new Scanner(System.in);
        System.out.println("ad yazin:");

        while (true) {
            try {
                person.add(scanner.next());
            } catch (NameException e) {
                System.out.println("davam et");
            }
            System.out.println("ad yazin:");
        }

    }
}


