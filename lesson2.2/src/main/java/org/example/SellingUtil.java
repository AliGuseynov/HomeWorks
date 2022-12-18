package org.example;

import org.example.models.Product;
import org.example.models.ProductCategory;
import org.example.models.Selling;
import org.example.models.SellingItem;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SellingUtil {
    private static Date date;

    public static void createSelling() {
        System.out.println("satis kodu yazin");
        Scanner scSellingCode = new Scanner(System.in);
        int sellingCode = scSellingCode.nextInt();
        System.out.println("satis etdiyiniz mehsulun idsini yazin");
        Scanner scSellingId = new Scanner(System.in);
        int sellingId = scSellingId.nextInt();
        System.out.println("satis etdiyiniz mehsulun sayini yazin");
        Scanner scSellingCount = new Scanner(System.in);
        int sellingCount = scSellingCount.nextInt();

        for (int i = 0; i < Config.products.size(); i++) {
            if (Config.products.get(i).getProductId() == sellingId & Config.products.get(i).getProductCount() != 0) {
                Selling selling = new Selling(sellingCode, new SellingItem(new Product(Config.products.get(i).getProductName(),
                        Config.products.get(i).getProductId(),
                        ProductCategory.valueOf(Config.products.get(i).getProductCategory().name()),
                        sellingCount, Config.products.get(i).getProductAmount()), sellingId, sellingCount),
                        sellingCount * Config.products.get(i).getProductAmount(), new Date());
                Config.sellings.add(selling);
                Config.products.get(i).setProductCount(Config.products.get(i).getProductCount() - sellingCount);
            }
            if (Config.products.get(i).getProductCount() == 0) {
                Config.products.remove(Config.products.get(i));
                System.out.println("bele bir mehsul qalmayibdir))");
            }
        }
        System.out.println(Config.products);
        System.out.println(Config.sellings);
    }

    public static void giveBackSellingProduct() {
        System.out.println("geri qaytarmaq istediyiniz mehsulun selling code-unu yazin");
        Scanner scSellingCode = new Scanner(System.in);
        int sellingCode = scSellingCode.nextInt();
        System.out.println("geri qaytarmaq istediyiniz mehsulun sayini yazin");
        Scanner scSellingBackCount = new Scanner(System.in);
        int sellingBackCount = scSellingBackCount.nextInt();

        for (int i = 0; i < Config.sellings.size(); i++) {
            if (Config.sellings.get(i).getSellingId() == sellingCode) {
                Config.sellings.get(i).getSellingItem().getProduct().setProductCount(Config.sellings.get(i).getSellingItem().getProduct().getProductCount() - sellingBackCount);
                for (int j = 0; j < Config.sellings.size(); j++) {
                    if (Config.products.get(j).getProductId() == Config.sellings.get(i).getSellingItem().getProduct().getProductId()) {
                        Config.products.get(j).setProductCount(Config.products.get(j).getProductCount() + sellingBackCount);

                    } else {
                        Config.products.add(Config.sellings.get(i).getSellingItem().getProduct());
                    }
                }
            }
            System.out.println(Config.sellings);

        }

    }

    public static void deleteSellingByCode() {
        System.out.println("silmek istediyiniz selling code-unu yazin");
        Scanner scDeletedSellingCode = new Scanner(System.in);
        int deletedSellingCode = scDeletedSellingCode.nextInt();
        for (int i = 0; i < Config.sellings.size(); i++) {
            if (Config.sellings.get(i).getSellingId() == deletedSellingCode) {
                Config.sellings.remove(Config.sellings.get(i));
                System.out.println(Config.sellings);
            }
        }
    }

    public static void printAllSellings() {
        for (int i = 0; i < Config.sellings.size(); i++) {
            System.out.println(Config.sellings.get(i));
        }
    }

    public static void findSellingByDate() throws ParseException {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("date yazin  bu formada dd/MM/yyyy ");
        Scanner scDate = new Scanner(System.in);
        Date date = formatter.parse(scDate.next());
        for (int i = 0; i < Config.sellings.size(); i++) {
            if (Config.sellings.get(i).getSellingDate().compareTo(date) == 0) {
                System.out.println(Config.sellings.get(i));
            }
        }
    }

    public static void findSellingByTwoDate() throws ParseException {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("birinci date-i bu formada dd/MM/yyyy yazin");
        Scanner scDateFirst = new Scanner(System.in);
        Date dateFirst = formatter.parse(scDateFirst.next());
        System.out.println("ikinci date-i bu formada dd/MM/yyyy yazin");
        Scanner scDateSecond = new Scanner(System.in);
        Date dateSecond = formatter.parse(scDateSecond.next());
        for (int i = 0; i < Config.sellings.size(); i++) {
            if (Config.sellings.get(i).getSellingDate().compareTo(dateFirst) == 1 &&
                    Config.sellings.get(i).getSellingDate().compareTo(dateSecond)==-1) {
                System.out.println(Config.sellings.get(i));
            }
        }
    }

    public static void findSellingById() {
        System.out.println("satis kodu yazin ki capa vere bilek");
        Scanner scSellingCode = new Scanner(System.in);
        int sellingCode = scSellingCode.nextInt();
        for (int i = 0; i < Config.sellings.size(); i++) {
            if (Config.sellings.get(i).getSellingId() == sellingCode) {
                System.out.println(Config.sellings.get(i));
            }
        }
    }
}
