package operation;

import java.util.Scanner;

public class Operations {
    public static void start(){
        boolean exit = false;
        int operations=operationBySalesOrProduct();
        while (!exit) {

            if (operations == 1) {

                int operation = operationProduct();

                switch (operation) {

                    case 1:
                        UserOfProducts.addProductByUser();
                        break;
                    case 2:
                        UserOfProducts.updateProductByUser();
                        break;
                    case 3:
                        UserOfProducts.removeProductByUser();
                        break;
                    case 4:
                        UserOfProducts.showAllProducts();
                        break;
                    case 5:
                        UserOfProducts.findWithCategoryByUser();
                        break;
                    case 6:
                        UserOfProducts.findwithRangePriceByUser();
                        break;
                    case 7:
                        UserOfProducts.findWithProductNameByUser();
                        break;
                    default:
                        exit = true;

                }


            } else if (operations == 2) {

                int operation = showChooseOperation();
                switch (operation) {
                    case 1:
                        UserOfSales.addSalesByUser();
                        break;
                    case 2:
                        UserOfSales.returnProductByUser();
                        break;
                    case 3:
                        UserOfSales.removeSaleByUser();
                        break;
                    case 4:
                        UserOfSales.showAllSales();
                        break;
                    case 5:
                        UserOfSales.findSaleWithDateByUser();
                        break;
                    case 6:
                        UserOfSales.showSalesPriceRangeByUser();
                        break;
                    case 7:
                        UserOfSales.findSaleByDate();
                        break;
                    case 8:
                        UserOfSales.findSaleWithIdByUser();
                        break;
                }

            }else {
                exit = true;
            }

        }
        }

    public static int operationBySalesOrProduct() {
        System.out.println("1. Məhsullar üzərində əmeliyyat aparmaq");
        System.out.println("2. Satışlar üzerində əmeliyyat aparmaq");
        System.out.println("3. Sistemdən çıxmaq");

        System.out.print("Cavabınızı daxil edin: ");
        Scanner sc= new Scanner(System.in);
        int input = sc.nextInt();
        return input;
    }
    public static int showChooseOperation() {
        System.out.println("1 Yeni satış əlavə et");
        System.out.println("2 Satışdakı hansisa məhsulun geri qaytarılması (silinməsi)");
        System.out.println("3 Satışın silinməsi");
        System.out.println("4 Bütün satışların ekrana çıxarəlması");
        System.out.println("5 Verilən tarix aralığına görə satışları göstər");
        System.out.println("6 Verilən məbləğ aralıgına görə satışları göstər");
        System.out.println("7 Verilən tarixə görə satışları göstər");
        System.out.println("8 Verilmiş nömrəyə əsasən həmin nömrəli satışın məlumatlarının göstərilməsi");

        System.out.print("Cavabınızı daxil edin:... ");
        Scanner sc=new Scanner(System.in);
        int productOperation=sc.nextInt();
        return productOperation;
    }
    public static int operationProduct() {
        System.out.println("1 Yeni məhsul əlavə et");
        System.out.println("2 Mehsul üzərində düzəliş et");
        System.out.println("3 Məhsulu sil");
        System.out.println("4 Bütün məhsulları göstər");
        System.out.println("5 Kategoriyasina göre mehsullari göstər");
        System.out.println("6 Qiymət aralıgına görə məhsulları göstər");
        System.out.println("7 Məhsullar arasında ada görə axtarış et");

        System.out.print("Cavabınızı daxil edin:.. ");

        Scanner sc=new Scanner(System.in);
        int productOperation=sc.nextInt();
        return productOperation;
    }
}
