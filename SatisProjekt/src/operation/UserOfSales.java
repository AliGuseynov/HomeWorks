package operation;

import model.Product;
import model.Sales;
import model.SalesItems;
import repos.ProductRepo;
import repos.SalesRepo;
import repos.factory.ProductFactory;
import repos.factory.SalesFactory;
import service.ProductService;
import service.SalesService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class UserOfSales {
    public static SalesRepo salesRepo = SalesFactory.createProductRepo("memory");

    private static SalesService salesService = new SalesService();
    private static ProductRepo productRepo = ProductFactory.createProductRepo("memory");
    private static ProductService productService = new ProductService();



    public static void addSalesByUser() {
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        List<SalesItems> salesItems = new ArrayList<>();
        System.out.print("Satışın idisini əlavə edin: ");
        String id = sc.nextLine();
        System.out.println("Satışın ödənişini əlavə edin: ");
        double salesPay = sc1.nextDouble();
        System.out.println("Satışın melumatlarini əlavə edin: ");
        System.out.println("Satışın məlumat idisini əlavə edin:");
        String salesItemId = sc.nextLine();
        System.out.println("Satışın mehsullarini elave edin ");
        System.out.println("Məhsulun idisini daxil edin");
        String productId = sc.nextLine();
        Product product = productRepo.findById(productId);
        System.out.println("Məhsulun sayını daxil edin");
        double count = sc1.nextDouble();

        LocalDate date = LocalDate.of(2020, 03, 12);

        salesItems.add(new SalesItems(salesItemId, product, count));
        salesService.addSale(new Sales(id, salesPay, salesItems, date));
    }

    public static void returnProductByUser() {
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        System.out.print("Satışın nömrəsini daxil edin: ");
        String salesNumber = sc.nextLine();
        System.out.print("Satışın item nömrəsini daxil edin: ");
        String salesItemNumber = sc.nextLine();
        System.out.print("Məhsulun kodunu daxil edin: ");
        double count = sc1.nextDouble();
        salesService.returnSales(salesNumber, salesItemNumber, count);
    }

    public static void removeSaleByUser() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Satışın nömrəsini daxil edin: ");
        String salesNumber = sc.nextLine();
        salesService.deletedSales(salesRepo.findBySerialNumber(salesNumber));
    }

    public static void findSaleWithDateByUser() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Başlanğıc tarixin ilini, ayını, gününü əlavə edin: ");
        System.out.print("il: ");
        int startYear = sc.nextInt();
        System.out.print("ay: ");
        int startMonth = sc.nextInt();
        System.out.print("gün: ");
        int startDay = sc.nextInt();
        LocalDate localDate1 = LocalDate.of(startYear, startMonth, startDay);
        System.out.println("Son tarixin ilini, ayını, gününü əlavə edin: ");
        System.out.print("il: ");
        int endYear = sc.nextInt();
        System.out.print("ay: ");
        int endMonth = sc.nextInt();
        System.out.print("gün: ");
        int endDay = sc.nextInt();
        LocalDate localDate2 = LocalDate.of(endYear, endMonth, endDay);
        salesService.findSalesByRangeDate(localDate1, localDate2);
    }

    public static void findSaleByDate() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Satışın ilini, ayını, gününü daxil edin: ");
        System.out.print("il: ");
        int year = sc.nextInt();
        System.out.print("ay: ");
        int month = sc.nextInt();
        System.out.print("gün: ");
        int day = sc.nextInt();
        LocalDate localDate = LocalDate.of(year, month, day);
        salesService.findSalesByDate(localDate);

    }
    public static void findSaleWithIdByUser(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Satışın nömrəsini daxil edin: ");
        String salesNumber = sc.nextLine();
       salesService.findSalesById(salesNumber);
    }
    public static void showAllSales(){
        salesService.allSales();
    }
    public static void showSalesPriceRangeByUser(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Görmək istədiyiniz ödənişlərin maksimumu yazın");
        double maxprice=sc.nextDouble();
        System.out.println("Görmək istədiyiniz ödənişlərin minumumunu yazın");
        double minprice=sc.nextDouble();
        salesService.findSalesByRangePay(minprice,maxprice);
    }
}
