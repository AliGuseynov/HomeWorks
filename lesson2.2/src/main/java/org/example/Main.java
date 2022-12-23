package org.example;

import org.example.repos.ProductRepo;
import org.example.repos.impl.ProductMemoryImpl;
import org.example.services.ProductService;
import org.example.services.SellingService;

import java.util.Scanner;

public class Main {

    public static void main(String[] argv) throws Exception {
        ProductService productService = new ProductService();
        SellingService sellingService = new SellingService();

        while (true) {
            System.out.println("emeliyyati secin\n" +
                    "-1 Mehsullar uzerinde emeliyyat aparmaq\n" +
                    "-2 Satislar uzerinde emeliyyat aparmaq\n" +
                    "-3 Sistemden cixmaq");
            Scanner scMenu = new Scanner(System.in);
            int menu = scMenu.nextInt();
            if (menu == 1) {
                while (true) {
                    System.out.println("emeliyyati secin\n" +
                            "-0 geriye qayit\n" +
                            "-1 Mehsullar yarat\n" +
                            "-2 mehsulu silin\n" +
                            "-3 mehsulu update edin\n" +
                            "-4 Butun mehsullari goster\n" +
                            "-5 Categoriyasina gore mehsullari goster\n" +
                            "-6 Qiymet araligina gore mehsullari goster\n" +
                            "-7 Mehsullar arasinda ada gore axtaris et"
                    );
                    Scanner scProductOperation = new Scanner(System.in);
                    int productOperation = scProductOperation.nextInt();
                    if (productOperation == 1) {
                        productService.addNewProduct();
                        break;
                    } else if (productOperation == 2) {
                        productService.deleteProduct();
                    } else if (productOperation == 3) {
                        productService.updateProductInfo();
                    } else if (productOperation == 4) {
                        productService.returnProducts();
                    } else if (productOperation == 5) {
                        productService.searchProductsByCategory();
                    } else if (productOperation == 6) {
                        productService.searchProductsByPriceRange();
                    } else if (productOperation == 7) {
                        productService.searchProductsByName();
                    } else if (productOperation == 0) {
                        break;
                    }
                }
            } else if (menu == 2) {
                while (true) {
                    System.out.println("emeliyyati secin\n" +
                            "-0 geriye qayit\n" +
                            "-1 Yeni satis elave etmek\n" +
                            "-2 Satisdaki hansisa mehsulun geri qaytarilmasi\n" +
                            "-3 Satisin silinmesi\n" +
                            "-4 Butun satislarin ekrana cixarilmasi\n" +
                            "-5 Verilen tarix araligina gore satislarin gosterilmesi\n" +
                            "-6 Verilen mebleg araligina gore satislarin gosterilmes\n" +
                            "-7 Verilmis bir tarixde olan satislarin gosterilmesi\n" +
                            "-8 Verilmis nomreye esasen hemin nomreli satisin melumatlarinin gosterilmesi \n"
                    );
                    Scanner scProductOperation = new Scanner(System.in);
                    int productOperation = scProductOperation.nextInt();
                    if (productOperation == 1) {
                        sellingService.createSelling();
                    } else if (productOperation == 2) {
                        sellingService.giveBackSellingProduct();
                    } else if (productOperation == 3) {
                        sellingService.deleteSellingByCode();
                    }
                    else if (productOperation == 4) {
                        sellingService.printAllSellings();
                    } else if (productOperation == 5) {
                        sellingService.findSellingByTwoDate();
                    } else if (productOperation == 6) {
                    } else if (productOperation == 7) {
                        sellingService.findSellingByDate();
                    } else if (productOperation == 8) {
                        sellingService.findSellingById();
                    } else if (productOperation == 0) {
                        break;
                    }
                }
            } else if (menu == 3) {
                break;
            }


        }
    }
}