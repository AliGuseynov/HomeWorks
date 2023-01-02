package homeworks.homework1.task1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        switch (num) {
            case 1:
                System.out.println("yanvar");
                break;
            case 2:
                System.out.println("fevral");
                break;
            case 3:
                System.out.println("mart");
                break;
            case 4:
                System.out.println("aprel");
                break;
            case 5:
                System.out.println("may");
                break;
            case 6:
                System.out.println("iyul");
                break;
            case 7:
                System.out.println("iyun");
                break;
            case 8:
                System.out.println("avqust");
                break;
            case 9:
                System.out.println("sentyabr");
                break;
            case 10:
                System.out.println("oktyabr");
                break;
            case 11:
                System.out.println("noyabr");
                break;
            case 12:
                System.out.println("dekabr");
                break;
            default:
                System.out.println("intervala daxil deyil");
        }

    }
}
