package UI;

import Model.ItemCategory;
import Repositories.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UI {
    private static Repository repository;
    private static Scanner scanner = new Scanner(System.in);

    public static void run(Repository repo) {
        repository = repo;
        renderStageOption();
    }

    // Render Forks
    // -------------------------------------------------------------------------------------------
    public static void renderStageOption() {

        int input = 0;
        boolean whileRunner = true;

        while (whileRunner) {

            System.out.println("\n-1 Mehsullar uzerinde emeliyyat aparmaq\n" +
                    "-2 Satislar uzerinde emeliyyat aparmaq\n" +
                    "-3 Sistemden cixmaq\n");

            System.out.println("Type (waiting...): ");

            input = scanner.nextInt();

            switch (input) {
                case 1:
                    renderStageItems();
                    whileRunner = false;
                   break;
                case 2:
                    renderStageSales();
                    whileRunner = false;
                    break;
                case 3:
                    whileRunner = false;
                    break;
                default:
                    System.out.println("Input wrong number");
            }
        }
    }
    public static void renderStageItems() {

        int input = 0;
        boolean whileRunner = true;

        while (whileRunner) {

            System.out.println("\n  - 1 Yeni mehsul elave et  - userden yeni mehsul yaradilmasi ucun lazim olan melumatlari daxil edilmelidir\n" +
            "    - 2 Mehsul uzerinde duzelis et -  duzelis edilecek mehsulun code-u ve duzelis melumatlari daxil edilmelidir\n" +
            "    - 3 Mehsulu sil - mehsulu kodu daxil edilmelidir\n" +
            "    - 4 Butun mehsullari goster - butun mehsullar gosterilecek (kodu,adi,categoriyasi,sayi,qiymeti)\n" +
            "    - 5 Categoriyasina gore mehsullari goster - usere var olan kateqoriyalar gosteilecek ve onlar arasinda bir secim etmelidir ve secilmis kateqoriyadan olan butun mehsullar gosterilir (kodu,adi,categoriyasi,sayi,qiymeti)\n" +
            "    - 6 Qiymet araligina gore mehsullari goster - userden minmum ve maximum qiymetleri daxil etmesi istenilir ve hemin qiymet araliginda olan mehsullar gosterilir (kodu, adi,categoriyasi,sayi,qiymeti)\n" +
            "    - 7 Mehsullar arasinda ada gore axtaris et - useden text daxil etmesi istenilir ve adinda hemin text olan butun mehsullar gosterilir (kodu, adi,categoriyasi,sayi,qiymeti)\n" +
            "    - 8 Return\n");

            System.out.println("Type (waiting...): ");

            input = scanner.nextInt();

            switch (input) {
                case 1:
                    renderAddItem();
                    run(repository);
                    break;
                case 2:
                    //
                    run(repository);
                    break;
                case 3:
                    //
                    run(repository);
                    break;
                case 4:
                    renderFindAllItems();
                    run(repository);
                    break;
                case 5:
                    renderFindByCategory();
                    run(repository);
                    break;
                case 6:
                    //
                    run(repository);
                    break;
                case 7:
                    //
                    run(repository);
                    break;
                case 8:
                    whileRunner = false;
                    run(repository);
                    break;
                default:
                    System.out.println("Input wrond number");
            }
        }
    }
    public static void renderStageSales() {

        int input = 0;
        boolean whileRunner = true;

        while (whileRunner) {

            System.out.println("\n - 1 Yeni satis elave etmek - istifadeciden satis yaradilmasi ucun lazimi meulatlarin daxil edilmesi istenilir (mehsullarin kodlari)\n" +
            "    - 2 Satisdaki hansisa mehsulun geri qaytarilmasi( satisdan cixarilmasi) - userden satisin,cixarilacaq mehsulun ve sayinin daxil edilmesi istenilir\n" +
            "    - 3 Satisin silinmesi - satisin nomresine esasen silinmesi\n" +
            "    - 4 Butun satislarin ekrana cixarilmasi (nomresi,meblegi,mehsul sayi,tarixi)\n" +
            "    - 5 Verilen tarix araligina gore satislarin gosterilmesi - userden qebul edilen iki tarix araligindaki satislarin gosterilmesi (nomresi,meblegi,mehsul sayi,tarixi)\n" +
            "    - 6 Verilen mebleg araligina gore satislarin gosterilmesi - userden qebul edilen iki mebleg araligindaki satislarin gosterilmesi (nomresi,meblegi,mehsul sayi,tarixi)\n" +
            "    - 7 Verilmis bir tarixde olan satislarin gosterilmesi  - userden qebul edilmis bir tarixde olan satislarin gosterilmesi(nomresi,meblegi,mehsul sayi,tarixi)\n" +
            "    - 8 Verilmis nomreye esasen hemin nomreli satisin melumatlarinin gosterilmesi - userden qebul edilmis nomdereye esasen hemin nomreli satisin melumatlarinin gosterilmesi (nomresi,meblegi,mehsul sayi,tarixi, satis itemlari (nomresi,mehsul adi,sayi))\n" +
            "    - 9 Retrun\"");

            System.out.print("Type (waiting...): ");

            input = scanner.nextInt();

            switch (input) {
                case 1:
                    renderAddReceipt();
                    run(repository);
                    break;
                case 2:
                    renderRefundItem();
                    run(repository);
                    break;
                case 3:
                    renderRefundReceipt();
                    run(repository);
                    break;
                case 4:
                    renderFindAllReceipts();
                    run(repository);
                    break;
                case 5:
                    //
                    run(repository);
                    break;
                case 6:
                    //
                    run(repository);
                    break;
                case 7:
                    //
                    run(repository);
                    break;
                case 8:
                    //
                    run(repository);
                    break;
                case 9:
                    whileRunner = false;
                    run(repository);
                    break;
                default:
                    System.out.println("Input wrond number");
            }
        }

    }

    // Render ADD functions
    // -------------------------------------------------------------------------------------------
    public static void renderAddReceipt() {

        System.out.println("Item List: ");
        System.out.println(repository.getItems());
        scanner = new Scanner(System.in);

        System.out.println("\nEnter product ID and count: ");

        repository.addReceipt(scanner.nextLine());

        repository.getReceipts();
        run(repository);
    }


    //change method !
    public static void renderAddItem() {

        System.out.println("Choose new Item Details: ");
        String category = renderChooseCategory();

        scanner = new Scanner(System.in);
        System.out.println("Input Details: String name, double price, int count)");

        repository.addItem(scanner.nextLine(), category);

        renderFindAllItems();
        run(repository);
    }

    // Render REFUND functions
    //------------------------------------------------------------------------------------------------------------

    public static void renderRefundItem() {



    }

    public static void renderRefundReceipt() {
        System.out.println(repository.getReceipts());

        System.out.println("Input receiptId");
        scanner = new Scanner(System.in);

        repository.refundReceipt(scanner.nextLine());
    }

    // Render FIND functions
    //------------------------------------------------------------------------------------------------------------

    public static void renderFindAllItems() {
        System.out.println(repository.getItems());
    }

    public static void renderFindAllReceipts() {
        System.out.println(repository.getReceipts());
    }

    public static void renderFindByCategory() {

        String category = renderChooseCategory();

        System.out.println(repository.findByCategory(category));;

    }

    //------------------------------------------------------------------------------------------------------------

    public static String renderChooseCategory() {

        System.out.println("Choose Item Category");

        String[] input = Arrays.toString(ItemCategory.values()).replaceAll("^.|.$", "").split(", ");

        for (int i = 0; i < input.length; i ++ ) {
            System.out.println(i + 1 + " - " + input[i]);
        }

        scanner = new Scanner(System.in);
        int categoryIndex = scanner.nextInt();

        return input[categoryIndex - 1];
    }

    public static List<Integer> inputValidation(String input, int countOfVariables) {

        scanner = new Scanner(System.in);

        return null;

    }
}
