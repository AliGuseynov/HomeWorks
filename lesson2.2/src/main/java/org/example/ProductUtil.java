package org.example;

import org.example.models.Product;
import org.example.models.ProductCategory;

import java.util.Scanner;

public class ProductUtil {
    public static void createdProduct() {
        System.out.println("nece mehsul elave etmek isteyirsiniz?");
        Scanner scProductCreatingCount = new Scanner(System.in);
        int productCreatingCount = scProductCreatingCount.nextInt();
        for (int i = 0; i < productCreatingCount; i++) {
            System.out.println("mehsulun idsi");
            Scanner scProductId = new Scanner(System.in);
            int productId = scProductId.nextInt();

            System.out.println("mehsulun adini daxil edin");
            Scanner scProductName = new Scanner(System.in);
            String productName = scProductName.nextLine();

            System.out.println("mehsulun kategoriyasi ancaq MOBILE COMPUTER MOUSE PRINTER varimizdi");
            Scanner scProductCategory = new Scanner(System.in);
            String productCategory = scProductCategory.nextLine();

            System.out.println("mehsulun sayi");
            Scanner scProductCount = new Scanner(System.in);
            int productCount = scProductCount.nextInt();
            System.out.println("mehsulun qiymeti");
            Scanner scProductAmount = new Scanner(System.in);
            int productAmount = scProductAmount.nextInt();
            Product product = new Product(productName, productId, ProductCategory.valueOf(productCategory), productCount,productAmount);
            Config.products.add(product);
        }
        printAllProduct();

    }

    public static void deleteProduct() {
        System.out.println("hansi idli mehsulu silmek isteyirsiniz?");
        Scanner scDeletedProductId = new Scanner(System.in);
        int deletedProductId = scDeletedProductId.nextInt();
        for (int i = 0; i < Config.products.size(); i++) {
            if (Config.products.get(i).getProductId() == deletedProductId) {
                Config.products.remove(Config.products.get(i));
                printAllProduct();
            }
        }
    }

    public static void updateProduct() {
        System.out.println("hansi idli mehsulu update etmek isteyirsiniz?");
        Scanner scUpdatedProductId = new Scanner(System.in);
        int updatedProductId = scUpdatedProductId.nextInt();
        for (int i = 0; i < Config.products.size(); i++) {
            if (Config.products.get(i).getProductId() == updatedProductId) {
                System.out.println("yeni idni yazin");
                Scanner scUpdatedElementId = new Scanner(System.in);
                int updatedElementId = scUpdatedElementId.nextInt();

                System.out.println("yeni ad yazin");
                Scanner scUpdatedElementName = new Scanner(System.in);
                String updatedElementName = scUpdatedElementName.nextLine();

                System.out.println("yeni category yazin");
                Scanner scUpdatedElementCategory = new Scanner(System.in);
                String updatedElementCategory = scUpdatedElementCategory.nextLine();

                System.out.println("yeni count yazin");
                Scanner scUpdatedElementCount = new Scanner(System.in);
                int updatedElementCount = scUpdatedElementCount.nextInt();

                System.out.println("yeni count yazin");
                Scanner scUpdatedElementAmount = new Scanner(System.in);
                int updatedElementAmount = scUpdatedElementAmount.nextInt();

                Config.products.get(i).setProductId(updatedElementId);
                Config.products.get(i).setProductName(updatedElementName);
                Config.products.get(i).setProductAmount(updatedElementAmount);
                Config.products.get(i).setProductCategory(ProductCategory.valueOf(updatedElementCategory));
                Config.products.get(i).setProductCount(updatedElementCount);
                System.out.println("update olundu  ve update olunmus  mehsulumuz:" + Config.products);
            }
        }
    }

    public static void printAllProduct() {
        System.out.println("sizin butun mehsullariniz: ");
        for (int i = 0; i < Config.products.size(); i++) {
            System.out.println(Config.products.get(i));
        }
    }

    public static void searchByCategory() {
        System.out.println("Hansi categorylileri cixarmaq isteyirsiniz? \n" +
                "ancaq MOBILE COMPUTER MOUSE PRINTER varimizdi");
        Scanner scSearchByCategory = new Scanner(System.in);
        String searchByCategory = scSearchByCategory.nextLine();
        for (int i = 0; i < Config.products.size(); i++) {
            if (Config.products.get(i).getProductCategory().name().equals(searchByCategory)) {
                System.out.println(Config.products.get(i));
            }
        }
    }

    public static void searchByMinMaxAmount() {
        System.out.println("min deyer daxil edin");

        Scanner scminValue = new Scanner(System.in);
        int minValue = scminValue.nextInt();
        System.out.println("max deyer daxil edin");
        Scanner scmaxValue = new Scanner(System.in);
        int maxValue = scmaxValue.nextInt();

        for (int i = 0; i < Config.products.size(); i++) {
            if (Config.products.get(i).getProductAmount() <= maxValue &&
                    Config.products.get(i).getProductAmount() > minValue) {
                System.out.println(Config.products.get(i));
            }
        }
    }

    public static void searchByName() {
        System.out.println("axtardiginiz texti daxil edin:");
        Scanner scSearchingText=new Scanner(System.in);
        String searchingText=scSearchingText.nextLine();
        for (int i = 0; i < Config.products.size(); i++) {
            if (Config.products.get(i).getProductName().contains(searchingText)) {
                System.out.println(Config.products.get(i));
            }
        }
    }

}

