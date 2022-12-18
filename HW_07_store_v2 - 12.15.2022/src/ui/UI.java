package ui;

import model.Item;
import model.ItemCategory;
import model.Receipt;
import service.ItemService;
import service.ReceiptService;
import service.SaleItemService;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UI {

    private ItemService itemService = new ItemService();
    private ReceiptService receiptService = new ReceiptService();
    private SaleItemService saleItemService = new SaleItemService();

    private static Scanner scanner = new Scanner(System.in);

    public void run() {
        renderStageOption();
    }

    public void renderStageOption() {

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

    public void renderStageItems() {

        int input = 0;
        boolean whileRunner = true;

        while (whileRunner) {

            System.out.println(
                    "    - 1 Yeni mehsul elave et  - userden yeni mehsul yaradilmasi ucun lazim olan melumatlari daxil edilmelidir\n" +
                    "    - 2 Mehsul uzerinde duzelis et -  duzelis edilecek mehsulun code-u ve duzelis melumatlari daxil edilmelidir\n" +
                    "    - 3 Mehsulu sil - mehsulu kodu daxil edilmelidir\n" +
                    "    - 4 Butun mehsullari goster - butun mehsullar gosterilecek (kodu,adi,categoriyasi,sayi,qiymeti)\n" +
                    "    - 5 Categoriyasina gore mehsullari goster - usere var olan kateqoriyalar gosteilecek ve onlar arasinda bir secim etmelidir ve secilmis kateqoriyadan olan butun mehsullar gosterilir (kodu,adi,categoriyasi,sayi,qiymeti)\n" +
                    "    - 6 Qiymet araligina gore mehsullari goster - userden minmum ve maximum qiymetleri daxil etmesi istenilir ve hemin qiymet araliginda olan mehsullar gosterilir (kodu, adi,categoriyasi,sayi,qiymeti)\n" +
                    "    - 7 Mehsullar arasinda ada gore axtaris et - useden text daxil etmesi istenilir ve adinda hemin text olan butun mehsullar gosterilir (kodu, adi,categoriyasi,sayi,qiymeti)\n" +
                    "    - 8 Generate Random Items\n" +
                    "    - 9 Return\n");

            System.out.println("Type (waiting...): ");

            input = scanner.nextInt();

            switch (input) {
                case 1:
                    renderAddItem();
                    run();
                    break;
                case 2:
                    renderEditItem();
                    run();
                    break;
                case 3:
                    renderDeleteItem();
                    run();
                    break;
                case 4:
                    renderFindAllItems();
                    run();
                    break;
                case 5:
                    renderFindByCategory();
                    run();
                    break;
                case 6:
                    renderFindByPriceRange();
                    run();
                    break;
                case 7:
                    renderFindByName();
                    run();
                    break;
                case 8:
                    renderGenerateRandomItems();
                    run();
                    break;
                case 9:
                    whileRunner = false;
                    run();
                    break;
                default:
                    System.out.println("Input wrond number");
            }
        }

    }

    public void renderStageSales() {

        int input = 0;
        boolean whileRunner = true;

        while (whileRunner) {

            System.out.println(
                    "    - 1 Yeni satis elave etmek - istifadeciden satis yaradilmasi ucun lazimi meulatlarin daxil edilmesi istenilir (mehsullarin kodlari)\n" +
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
                    run();
                    break;
                case 2:
                    renderRefundItem();
                    run();
                    break;
                case 3:
                    renderRefundReceipt();
                    run();
                    break;
                case 4:
                    renderFindAllReceipts();
                    run();
                    break;
                case 5:
                    //
                    run();
                    break;
                case 6:
                    //
                    run();
                    break;
                case 7:
                    //
                    run();
                    break;
                case 8:
                    //
                    run();
                    break;
                case 9:
                    whileRunner = false;
                    run();
                    break;
                default:
                    System.out.println("Input wrond number");
            }
        }




    }

    // renderStageItems functions
    //-----------------------------------------------------------------------------------------------------

    // 1-1
    public void renderAddItem() {

        System.out.println("Choose new Item Details: ");
        String category = renderChooseCategory();

        scanner = new Scanner(System.in);
        System.out.println("Input Details: String name, double price, int count)");

        itemService.addItem(scanner.nextLine(), category);

        renderFindAllItems();
    }

    // 1-2
    public void renderEditItem() {

        renderFindAllItems();

        scanner = new Scanner(System.in);

        System.out.println("Input Item ID");
        long id = Long.parseLong(scanner.nextLine());

        System.out.println("Input Details: String name, double price, int count");
        String input = scanner.nextLine();

        System.out.println("Choose new Item Details: ");
        String category = renderChooseCategory();

        itemService.editItem(id, input, category);
    }

    // 1-3
    public void renderDeleteItem() {

        scanner = new Scanner(System.in);
        System.out.println("Input Item ID:");

        itemService.deleteItem(scanner.nextLong());
    }

    // 1-4
    public void renderFindAllItems()  {

        System.out.println("All Items");

        for (Item e : itemService.getItems())
            System.out.println(e);
    }

    // 1-5
    public void renderFindByCategory() {

        String category = renderChooseCategory();

        List<Item> result = itemService.findByCategory(category);

        for (Item e : result)
            System.out.println(e);
    }

    // 1-6
    public void renderFindByPriceRange() {

        scanner = new Scanner(System.in);

        System.out.println("Input min price: ");
        double min = scanner.nextDouble();


        System.out.println("Input max price: ");
        double max = scanner.nextDouble();

        List<Item> result = itemService.findByPriceRange(min, max);

        for (Item e : result)
            System.out.println(e);
    }

    // 1-7
    public void renderFindByName() {

        scanner = new Scanner(System.in);

        System.out.println("Input Item name: ");

        List<Item> result = itemService.findByName(scanner.nextLine());

        for (Item e : result)
            System.out.println(e);
    }

    // 1-8
    public void renderGenerateRandomItems() {

        scanner = new Scanner(System.in);
        System.out.println("Input count");

        itemService.renderGenerateRandomItems(scanner.nextInt());

        renderFindAllItems();
    }

    // renderStageSales functions
    //-----------------------------------------------------------------------------------------------------

    // 2-1
    public void renderAddReceipt() {

        renderFindAllItems();
        scanner = new Scanner(System.in);

        System.out.println("\nEnter product ID and count: ");

        receiptService.addReceipt(scanner.nextLine());
    }

    // 2-2
    public void renderRefundItem() {}

    // 2-3
    public void renderRefundReceipt() {}

    // 2-4
    public void renderFindAllReceipts() {

        System.out.println("All Receipts: ");

        List<Receipt> receipts = receiptService.getReceipts();

        for (Receipt e : receipts)
            System.out.println(e);
    }

    // -------------------------------------------------------------

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

}
