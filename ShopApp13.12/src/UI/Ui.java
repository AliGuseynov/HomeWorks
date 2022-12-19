package UI;

import Models.Item;
import Models.ItemCategorie;
import Models.Receipt;
import Repositories.ItemRepo;
import Repositories.ReceiptRepo;
import Repositories.Repository;
import Seeders.GlobalSeeder;
import service.ItemService;
import service.ReceiptService;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ui {

//    private static Repository repo;

    private static ItemService itemService;
    private static ReceiptService receiptService;

    public Ui() {
        itemService = new ItemService();
        receiptService = new ReceiptService(itemService);
        itemService.setReceiptService(receiptService);
    }

    public void run() {


        System.out.print(
                "-1 Mehsullar uzerinde emeliyyat aparmaq\n" +
                        "-2 Satislar uzerinde emeliyyat aparmaq\n" +
                        "-3 Sistemden cixmaq \n" +
                        "Input number: ");
        Scanner scanner = new Scanner(System.in);

        String input = "0";

        boolean whileBreaker = true;

        while (whileBreaker) {
            input = scanner.nextLine();

            switch (input) {
                case "1":
                    stageItemsOps();
                    whileBreaker = false;
                    break;
                case "2":
                    stageSalesOps();
                    whileBreaker = false;
                    break;
                case "3":
                    whileBreaker = false;
                    break;
                default:
                    System.out.print("Wrong option! Enter number: ");
//                run();
//                whileBreaker = false;
            }


        }
    }


    public void stageItemsOps() {
        System.out.print(
                "    - 1 Yeni mehsul elave et  - userden yeni mehsul yaradilmasi ucun lazim olan melumatlari daxil edilmelidir\n" +
                        "    - 2 Mehsul uzerinde duzelis et -  duzelis edilecek mehsulun code-u ve duzelis melumatlari daxil edilmelidir\n" +
                        "    - 3 Mehsulu sil - mehsulu kodu daxil edilmelidir\n" +
                        "    - 4 Butun mehsullari goster - butun mehsullar gosterilecek (kodu,adi,categoriyasi,sayi,qiymeti)\n" +
                        "    - 5 Categoriyasina gore mehsullari goster - usere var olan kateqoriyalar gosteilecek ve onlar arasinda bir secim etmelidir ve secilmis kateqoriyadan olan butun mehsullar gosterilir (kodu,adi,categoriyasi,sayi,qiymeti)\n" +
                        "    - 6 Qiymet araligina gore mehsullari goster - userden minmum ve maximum qiymetleri daxil etmesi istenilir ve hemin qiymet araliginda olan mehsullar gosterilir (kodu, adi,categoriyasi,sayi,qiymeti)\n" +
                        "    - 7 Mehsullar arasinda ada gore axtaris et - useden text daxil etmesi istenilir ve adinda hemin text olan butun mehsullar gosterilir (kodu, adi,categoriyasi,sayi,qiymeti)\n"
                        + "    - 8 Başlanğıca dön \n" +
                        "Enter number: ");
        Scanner scanner = new Scanner(System.in);

        String input = "0";

        boolean whileBreaker = true;

        while (whileBreaker) {
            input = scanner.nextLine();

            switch (input) {
                case "1":
                    createItem();
                    whileBreaker = false;
                    break;
                case "2":
                    editItem();
                    whileBreaker = false;
                    break;
                case "3":
                    removeItem();
                    whileBreaker = false;
                    break;

                case "4":
                    getAllItems();
                    whileBreaker = false;
                    break;
                case "5":
                    getItemsByCategory();
                    whileBreaker = false;
                    break;
                case "6":
                    findItemsByPriceRange();
                    whileBreaker = false;
                    break;
                case "7":
                    findItemsByName();
                    whileBreaker = false;
                    break;
                case "8":
                    whileBreaker = false;
                    run();
                    break;
                default:
                    System.out.print("Wrong option! Enter number: ");
//                run();
//                whileBreaker = false;
            }
        }
    }

    public void stageSalesOps() {

        System.out.print(
                "    - 1 Yeni satis elave etmek - istifadeciden satis yaradilmasi ucun lazimi meulatlarin daxil edilmesi istenilir (mehsullarin kodlari)\n" +
                        "    - 2 Satisdaki hansisa mehsulun geri qaytarilmasi( satisdan cixarilmasi) - userden satisin,cixarilacaq mehsulun ve sayinin daxil edilmesi istenilir\n" +
                        "    - 3 Satisin silinmesi - satisin nomresine esasen silinmesi\n" +
                        "    - 4 Butun satislarin ekrana cixarilmasi (nomresi,meblegi,mehsul sayi,tarixi)\n" +
                        "    - 5 Verilen tarix araligina gore satislarin gosterilmesi - userden qebul edilen iki tarix araligindaki satislarin gosterilmesi (nomresi,meblegi,mehsul sayi,tarixi)\n" +
                        "    - 6 Verilen mebleg araligina gore satislarin gosterilmesi - userden qebul edilen iki mebleg araligindaki satislarin gosterilmesi (nomresi,meblegi,mehsul sayi,tarixi)\n" +
                        "    - 7 Verilmis bir tarixde olan satislarin gosterilmesi  - userden qebul edilmis bir tarixde olan satislarin gosterilmesi(nomresi,meblegi,mehsul sayi,tarixi)\n" +
                        "    - 8 Verilmis nomreye esasen hemin nomreli satisin melumatlarinin gosterilmesi - userden qebul edilmis nomdereye esasen hemin nomreli satisin melumatlarinin gosterilmesi\n" +
                        "    - 9  Başlanğıca dön\n" +
                        "Enter number: ");
        Scanner scanner = new Scanner(System.in);

        String input = "0";

        boolean whileBreaker = true;

        while (whileBreaker) {
            input = scanner.nextLine();

            switch (input) {
                case "1":
                    renderAddReceipt();
                    whileBreaker = false;
                    break;
                case "2":
                    refundItem();
                    whileBreaker = false;
                    break;
                case "3":
                    removeReceipt();
                    whileBreaker = false;
                    break;

                case "4":
                    getAllReceipts();
                    whileBreaker = false;
                    break;
                case "5":
                    findReceiptsByDate();
                    whileBreaker = false;
                    break;
                case "6":
                    findReceiptsByPriceRange();
                    whileBreaker = false;
                    break;
                case "7":
                    findReceiptsBySpecificDate();
                    whileBreaker = false;
                    break;
                case "8":
                    renderGetReceipt();
                    whileBreaker = false;
                    break;
                case "9":
                    whileBreaker = false;
                    run();
                    break;
                default:
                    System.out.print("Wrong option! Enter number: ");
//                run();
//                whileBreaker = false;
            }

        }
    }




    public void renderAddReceipt(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(itemService.getItemsList());
        System.out.print("Enter Product ID and Count example (122 5 45 2): ");
        boolean whileBreaker = true;
        String input = null;
        while (whileBreaker){

            input = scanner.nextLine();
            whileBreaker = !valideteNumber(input);
            System.out.println("Error: wrong format.. enter Product ID and Count example (122 5 45 2)");
        }
        receiptService.addReceipt(input);
        run();
    }

    private boolean valideteNumber(String text){
        Pattern pattern = Pattern.compile("^[0-9_ ]*$");
        Matcher matcher = pattern.matcher(text);
        boolean matchFound = matcher.find();
        if(matchFound) {
            return true;
        } else {
            return false;
        }
    }

    public void getAllItems(){
        System.out.println(itemService.getItemsList());
        run();
    }

    public void removeItem(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter item ID: ");
        String input = scanner.nextLine();
        itemService.deleteItem(input);
        run();
    }

    public void createItem(){

        System.out.print("New item creation: \n");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter item name: ");
        String itemName = scanner.nextLine();

        System.out.print("Enter item price: ");
        Double itemPrice = Double.parseDouble(scanner.nextLine());

        System.out.print("Enter item count: ");
        Integer itemCount = Integer.parseInt(scanner.nextLine());

        ItemCategorie[] categoriesEnums = ItemCategorie.values();
        String categories = "Kateqoriyalar: ";
        for (int i = 0; i< categoriesEnums.length; i++){
            categories =  categories + i + " - " + categoriesEnums[i] + "; ";
        }
        System.out.println(categories);

        System.out.print("Enter item category ID: ");

        int itemId = -1;
        boolean whilebreaker = true;
        ItemCategorie itemCategory = null;
        while (whilebreaker){
            itemId = Integer.parseInt(scanner.nextLine());
            if (itemId >=0 && itemId <5){
                itemCategory = categoriesEnums[itemId];
                whilebreaker = false;}
        }
        itemService.addItem(itemName, itemPrice, itemCount, itemCategory);

        run();
    }


    public void editItem(){

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter item id: ");
        long itemId = Long.parseLong(scanner.nextLine());
        Item itemToChange = itemService.findItemById(itemId);

        System.out.println(itemToChange);

        System.out.print("Old name: "+ itemToChange.getName() +
                "\nEnter item name: ");
        String itemName = scanner.nextLine();

        System.out.print("Old price:"+ itemToChange.getPrice() +
                "\nEnter item price: ");
        Double itemPrice = Double.parseDouble(scanner.nextLine());

        System.out.print("Old item count: "+ itemToChange.getCount() +
                "\nEnter item count: ");
        Integer itemCount = Integer.parseInt(scanner.nextLine());

        ItemCategorie[] categoriesEnums = ItemCategorie.values();
        String categories = "Kateqoriyalar: ";
        for (int i = 0; i< categoriesEnums.length; i++){
            categories =  categories + i + " - " + categoriesEnums[i] + "; ";
        }
        System.out.println(categories);

        System.out.print("Old category: "+ itemToChange.getCategory() +
                "\nEnter item category ID: ");

        int globalItemId = -1;
        boolean whilebreaker = true;
        ItemCategorie itemCategory = null;
        while (whilebreaker){
            globalItemId = Integer.parseInt(scanner.nextLine());
            if (globalItemId >=0 && globalItemId <5){
                itemCategory = categoriesEnums[globalItemId];
                whilebreaker = false;}
        }

        itemService.updateItem(itemId,itemName, itemPrice, itemCount, itemCategory);

        run();

    }


    public void getItemsByCategory(){
        ItemCategorie[] yourEnums = ItemCategorie.values();
        String categories = "Kateqoriyalar: ";
        for (int i = 0; i< yourEnums.length; i++){
            categories =  categories + i + " - " + yourEnums[i] + "; ";
        }
        System.out.println(categories);
        Scanner scanner = new Scanner(System.in);

        int input = 0;

        boolean whileBreaker = true;

        while (whileBreaker){
            input = scanner.nextInt();

            if (input >=0 && input <5) {
                itemService.findItemsByCategory(yourEnums[input]);
                run();
                whileBreaker = false;
            } else {

                System.out.print("Wrong option! Enter number from 1-4: ");}
        }}

    public void findItemsByPriceRange(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter price range. Format [Min price] [Max price] :");
        String input = scanner.nextLine();

        System.out.println(itemService.fintItemsByPriceRange(input));
//        System.out.println(repo.findItemsByPriceRange(input));

        run();

    }

    public void findItemsByName(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter item name: ");
        String input = scanner.nextLine();

        System.out.println(itemService.findItemByName(input));

        run();
    }



    public void refundItem(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Receipt ID:");
        boolean whileBreaker = true;
        Long receiptId = null;
        while (whileBreaker){
        String input = scanner.nextLine();
        if (valideteNumber(input)){
            receiptId = Long.parseLong(input);
            whileBreaker = false;
        } else {
            System.out.println("Wrong receipt number");
        }
        }

        Receipt receipt = receiptService.getReceiptById(receiptId);
        System.out.println(receipt);

        System.out.print("Enter itemID:");
        whileBreaker = true;
        int itemId = -1;
        while (whileBreaker){
            String input = scanner.nextLine();
            if (valideteNumber(input)){
                itemId = Integer.parseInt(input);
                whileBreaker = false;
            } else {
                System.out.println("Wrong item number");
            }
        }

        System.out.print("Enter item count:");
        whileBreaker = true;
        int itemCount = 0;
        while (whileBreaker){
            String input = scanner.nextLine();
            if (valideteNumber(input)){
                itemCount = Integer.parseInt(input);
                whileBreaker = false;
            } else {
                System.out.println("Wrong number");
            }
        }


        Receipt tempReceipt = receiptService.refundItemFromReceipt(receiptId, itemId, itemCount);

        if (tempReceipt == null){
            System.out.println("Wrong data");
        } else {
            System.out.println(tempReceipt);
        }

        run();
    }
    public void removeReceipt(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter receipt ID: ");
        boolean whileBreaker = true;
        Long receiptId = Long.parseLong("-1");
        String input = null;
        while (whileBreaker){

            input = scanner.nextLine();
            if (valideteNumber(input)){

                whileBreaker = false;
            }
        }
        System.out.println(receiptService.deleteReceipt(input));

        run();

    }
    public void getAllReceipts(){
        System.out.println(receiptService.getAllReceipts());
        run();
    }

    public void findReceiptsByDate(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter start date and end date. Format YYYY-MM-dd YYYY-MM-dd : ");
        String input = scanner.nextLine();

        System.out.println(receiptService.findReceiptsByDate(input));

        run();

    }
    public void findReceiptsByPriceRange(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter price range. Format: [Min price] [Max price]");
        boolean whilebreaker = true;
        String input = null;
        while (whilebreaker) {
            input = scanner.nextLine();
            if (valideteNumber(input)){
                whilebreaker = false;
            } else {
                System.out.println("Wrong format");}
        }

        System.out.println(receiptService.findReceiptsByPriceRange(input));

        run();

    }


    public void findReceiptsBySpecificDate(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter date for receipts. Format YYYY-MM-dd : ");
        String input = scanner.nextLine();

        System.out.println(receiptService.findReceiptsBySpecificDate(input));

        run();

    }

    public void renderGetReceipt (){

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Receipt ID :");
        String input = scanner.nextLine();
        System.out.println(receiptService.findReceiptById(Long.parseLong(input)));
        run();
    }

}
