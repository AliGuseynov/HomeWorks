package az.code.shopManagement.service;

import java.util.Scanner;

public class Operation {

    public static void mainMenu()
    {
        System.out.println(" -1 Mehsullar uzerinde emeliyyat aparmaq" + "\n" +

                " -2 Satislar uzerinde emeliyyat aparmaq" + "\n" +
                " -3 Sistemden cixmaq");
    }

    public static void productOperations() {
        System.out.println("- 1 Yeni mehsul elave et" + "\n" +
                "- 2 Mehsul uzerinde duzelis et" + "\n" +
                "- 3 Mehsulu sil - mehsulu kodu daxil edilmelidir" + "\n" +
                "- 4 Butun mehsullari goster - butun mehsullar gosterilecek" + "\n" +
                "- 5 Categoriyasina gore mehsullari goster " + "\n" +
                "- 6 Qiymet araligina gore mehsullari goster " + "\n" +
                "- 7 Mehsullar arasinda ada gore axtaris et" + "\n");
    }

    public static void purchaseOperations() {
        System.out.println("- 1 Yeni satis elave etmek " + "\n" +
                "- 2 Satisdaki hansisa mehsulun geri qaytarilmasi( satisdan cixarilmasi)" + "\n" +
                "- 3 Satisin silinmesi" + "\n" +
                "- 4 Butun satislarin ekrana cixarilmasi (nomresi,meblegi,mehsul sayi,tarixi)\n" +
                "- 5 Verilen tarix araligina gore satislarin gosterilmesi - userden qebul edilen iki tarix araligindaki satislarin gosterilmesi" + "\n" +
                "- 6 Verilen mebleg araligina gore satislarin gosterilmesi - userden qebul edilen iki mebleg araligindaki satislarin gosterilmesi" + "\n" +
                "- 7 Verilmis bir tarixde olan satislarin gosterilmesi " + "\n" +
                "- 8 Verilmis nomreye esasen hemin nomreli satisin melumatlarinin gosterilmesi" + "\n");
    }
    public static void firstOption()
    {
        mainMenu();
        Scanner scan = new Scanner(System.in);
        int FIRST_OPTION = scan.nextInt();
        switch (FIRST_OPTION) {
            case (1): {
                productOperations();
                productChanges();
                break;
            }
            case (2): {
                purchaseOperations();
                purchaseChanges();
                break;
            }
            case (3): {

            }
        }
    }
    public static void productChanges(){
        Scanner scan = new Scanner(System.in);
        int SECOND_OPTION = scan.nextInt();
        switch (SECOND_OPTION) {
            case (1): {
                Marketable.createNewProduct();
                break;
            }
            case (2): {
                Marketable.updateProduct();
                break;
            }
            case (3): {
                Marketable.deleteProduct();
                break;
            }
            case (4): {
                System.out.println(Marketable.getAllProducts());
                break;
            }
            case (5): {
                Marketable.searchByCategory();
                break;
            }
            case (6): {
                Marketable.searchByPrice();
                break;
            }
            case (7): {
                Marketable.searchByName();
                break;
            }
        }
        System.out.println("\n\n");
        firstOption();
    }
    public static void purchaseChanges() {
        Scanner scan = new Scanner(System.in);
        int SECOND_OPTION = scan.nextInt();
        switch (SECOND_OPTION) {
            case (1): {
                Marketable.addPurchase();
                break;
            }
            case (2): {
                Marketable.returnProduct();
                break;
            }
            case (3): {
                Marketable.deletePurchase();
                break;
            }
            case (4): {
                Marketable.getAllPurchases();
                break;
            }
            case (5): {
                Marketable.searchPurchaseByPeriod();
                break;
            }
            case (6): {
                Marketable.searchPurchaseByPriceRange();
                break;
            }
            case (7): {
                Marketable.searchPurchaseByDate();
                break;
            }
            case (8): {
                Marketable.getPurchaseById();
                break;
            }
        }
        System.out.println("\n\n");
        firstOption();
    }
}

