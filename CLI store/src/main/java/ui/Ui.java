package ui;

import models.Product;
import models.SaleItem;
import repository.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ui {

    public static void startCLI(){

        System.out.println("\n1 - Show all items" +
                "\n2 - Add sale");
        Scanner scanner = new Scanner(System.in);
        Integer input = 0;
        while (true){

            System.out.print("Enter Option :");
            try {
                input  = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e){

            }


        if (input == 1 || input == 2) {
                break;
            } else {
                System.out.println("Wrong option...\n");
            }
        }

        switch (input){
            case 1:
                Repository.selectAllItems(true);
                startCLI();
                break;
            case 2:
                saleItem();
                break;
        }

        }


        public static void saleItem(){

        HashMap<String, Integer> hashSale = new HashMap<>();

        List<Product> products = Repository.selectAllItems(false);

//        products = products.stream().filter(a-> a.getCount()>0).collect(Collectors.toList());

        products.forEach(System.out::println);

            HashMap<String, Product> productHashMap = new HashMap<>();

            for (Product prod: products){
                productHashMap.put(prod.getCode(), prod);
            }


            // ^Initializing


            System.out.println("\nStart sale...");
            Scanner scanner = new Scanner(System.in);
            boolean sale = true;
            String productCode = null;
            int count = 0;

            while (sale) {
                while (true) {
                    Product tempprod = null;

                    System.out.print("Enter product code (stop - to end sale):");
                    try {
                        productCode = scanner.nextLine();

                        if (productCode.equals("stop")){
                            sale = false;
                        }

                        tempprod = productHashMap.get(productCode);
                        tempprod.printProduct();
                    } catch (NumberFormatException e) {
                    } catch (NullPointerException e){
                        System.out.println("Wrong product code");
                    }

                    System.out.print("Enter count :");
                    try {
                        count = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                    }

                    if (tempprod != null && count>0) {

                        addToSale(hashSale, productHashMap, tempprod, count);

                        if(checkContinue() == false){

                            Repository.createSale(hashSale, productHashMap);

                            saleItem();
                            sale = false;
                        }
                        break;
                    } else {
                        System.out.println("Wrong code...\n");
                    }
                }
            }

        }


        private static boolean checkContinue(){
            System.out.println("Add new sale, yes or no?");
            Scanner scanner = new Scanner(System.in);
            String input = "";
            while (true){
                input = String.valueOf(scanner.nextLine());
                if (input.equals("yes")|| input.equals("no")){
                break;
            } else {
                    System.out.println("else");
                }
            }
            if (input.equals("yes")){
                return true;
            } else {
                return false;
            }
        }

        private static void addToSale(HashMap<String, Integer> sale, HashMap<String, Product> productHashMap, Product item, Integer count){

        Product refProduct = productHashMap.get(item.getCode());

        if (!(refProduct.getCount() > count)){
          count = refProduct.getCount();
        }

        if (sale.containsKey(item.getCode())){
            sale.put(item.getCode(), count + sale.get(item.getCode()));
        } else {
            sale.put(item.getCode(), count);
        }
        productHashMap.get(item.getCode()).setCount(productHashMap.get(item.getCode()).getCount()-count);

        }




    }

