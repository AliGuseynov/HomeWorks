package az.code;

import az.code.business.SalesService;

import java.util.Scanner;

public class Print {
    SalesService salesService;

    public void forMenu() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Emeliyyat secin:\n 1 Yeni satish yaradin\n" +
                "2 Prosesi dayandir\n");
        System.out.print("Secim:");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("satish");
                salesService.addItem(1);
                break;

            case 2:
                System.out.println("Stop");
                break;
            default:
                System.out.println("YANLISH SECIM");
        }
    }
}
