package az.code;

import az.code.business.SalesService;
import az.code.repo.SaleRepository;

import java.util.Scanner;

public class Print {
    SalesService salesService = new SalesService();
    SaleRepository saleRepository = new SaleRepository();

    public void forMenu() throws Exception {
        Scanner scanner = new Scanner(System.in);
        int tmp = 5;
        while (tmp > 0) {
            System.out.println("Emeliyyat secin:\n 1 Yeni satish yaradin\n" +
                    "2 Prosesi dayandir\n");
            System.out.print("Secim:");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("satish");
                    saleRepository.product();
                    break;

                case 2:
                    salesService.newSales();
                    saleRepository.save();
                    System.out.println("Stop");
                    break;
                default:
                    System.out.println("YANLISH SECIM");
            }
            tmp--;
        }
    }
}
