package homework1.task4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isManual = false;
        boolean isBroken = false;//ilishme
        int weight = scanner.nextInt();
//        int speed = scanner.nextInt();


        if (isManual && weight > 1000) {
            System.out.println("stop");
        }
        if (!isManual && weight == 0 || isBroken || weight > 1000) {
            System.out.println("stop");
        }
        if (!isManual && weight <= 300 && isBroken) {
            System.out.println("max speed=" + 4);
        }
        if (!isManual && weight > 300 && weight <= 500 && !isBroken) {
            System.out.println("max speed=" + 3);
        }
        if (!isManual && weight > 500 && weight <= 800 && !isBroken) {
            System.out.println("max speed=" + 2);
        }
        if (!isManual && weight > 800 && weight <= 1000 && !isBroken) {
            System.out.println("max speed=" + 1);
        }
//        System.out.println("run");

    }
}
