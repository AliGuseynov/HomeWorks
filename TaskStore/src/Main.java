import models.IMarketable;
import models.Product;
import models.ProductCategory;
import models.Sale;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

public class Main {
    public static void main(String[] args) throws IOException {

        IMarketable store = new IMarketable();

        boolean exit = false;

        while (!exit){
            System.out.println("1. Məhsullar üzərində əmeliyyat aparmaq");
            System.out.println("2. Satışlar üzerində əmeliyyat aparmaq");
            System.out.println("3. Sistemdən çıxmaq");

            System.out.print("Cavabınızı daxil edin: ");

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int input = Integer.parseInt(reader.readLine());
            if (input == 1){
                System.out.println("1 Yeni məhsul əlavə et");
                System.out.println("2 Mehsul üzərində düzəliş et");
                System.out.println("3 Məhsulu sil");
                System.out.println("4 Bütün məhsulları göstər");
                System.out.println("5 Kategoriyasina göre mehsullari göstər");
                System.out.println("6 Qiymət aralıgına görə məhsulları göstər");
                System.out.println("7 Məhsullar arasında ada görə axtarış et");

                System.out.print("Cavabınızı daxil edin:.. ");
                int input2 = Integer.parseInt(reader.readLine());
                if(input2 == 1){
                    System.out.print("Məhsulun adını əlavə edin: ");
                    String name = reader.readLine();
                    System.out.print("Qiyməti əlavə edin: ");
                    double price = Double.parseDouble(reader.readLine());
                    System.out.print("Kateqoria əlavə edin: ");
                    ProductCategory category = ProductCategory.valueOf(reader.readLine());
                    System.out.print("Sayını əlavə edin: ");
                    int count = Integer.parseInt(reader.readLine());
                    String code = UUID.randomUUID().toString();

                    store.addNewProduct(new Product(name, price, category, count, code));
                }
                else if(input2 == 2){
                    System.out.print("Məhsulun kodunu daxil edin: ");
                    String code = reader.readLine();
                    System.out.print("Məhsulun yeni adını daxil edin: ");
                    String name = reader.readLine();
                    System.out.print("Yeni qiyməti daxil edin: ");
                    double price = Double.parseDouble(reader.readLine());
                    System.out.print("Yeni kateqoria daxil edin: ");
                    ProductCategory category = ProductCategory.valueOf(reader.readLine());
                    System.out.print("Cari sayını daxil edin: ");
                    int count = Integer.parseInt(reader.readLine());

                    store.replaceProductInfo(code, name, price, category, count);
                }
                else if(input2 == 3){
                    System.out.print("Məhsulun kodunu daxil edin: ");
                    String code = reader.readLine();

                    store.withdrawProductFromProducts(code);
                }
                else if(input2 == 4){
                    store.returnProducts();
                }
                else if(input2 == 5){
                    System.out.print("Məhsulun kateqoriasını daxil edin: ");
                    ProductCategory category = ProductCategory.valueOf(reader.readLine());

                    store.searchProductsByCategory(category);
                }
                else if(input2 == 6){
                    System.out.print("Aşağı qiymət sərhəddini daxil edin:");
                    double lowerPrice = Double.parseDouble(reader.readLine());
                    System.out.print("Yuxarı qiymət sərhəddini daxil edin:");
                    double higherPrice = Double.parseDouble(reader.readLine());

                    store.searchProductsByPriceRange(lowerPrice, higherPrice);
                }
                else if(input2 == 7){
                    System.out.print("Məhsulun adını daxil edin: ");
                    String name = reader.readLine();

                    store.searchProductsByName(name);
                }
                else exit = true;
            }
            else if (input == 2){
                System.out.println("1 Yeni satış əlavə et");
                System.out.println("2 Satışdakı hansisa məhsulun geri qaytarılması (silinməsi)");
                System.out.println("3 Satışın silinməsi");
                System.out.println("4 Bütün satışların ekrana çıxarəlması");
                System.out.println("5 Verilən tarix aralığına görə satışları göstər");
                System.out.println("6 Verilən məbləğ aralıgına görə satışları göstər");
                System.out.println("7 Verilən tarixə görə satışları göstər");
                System.out.println("8 Verilmiş nömrəyə əsasən həmin nömrəli satışın məlumatlarının göstərilməsi");

                System.out.print("Cavabınızı daxil edin:... ");
                int input2 = Integer.parseInt(reader.readLine());
                if(input2 == 1){
                    System.out.print("Satışın adını əlavə edin: ");
                    String name = reader.readLine();
                    System.out.println("Satışın ilini, ayını, gününü əlavə edin: ");
                    System.out.print("il: ");
                    int year = Integer.parseInt(reader.readLine());
                    System.out.print("ay: ");
                    int month = Integer.parseInt(reader.readLine());
                    System.out.print("gün: ");
                    int day = Integer.parseInt(reader.readLine());
                    Date date = new Date(year, month, day);

                    store.addNewSale(new Sale(name, date));
                }
                else if(input2 == 2){
                    System.out.print("Satışın nömrəsini daxil edin: ");
                    String salesNumber = reader.readLine();
                    System.out.print("Satışın item nömrəsini daxil edin: ");
                    String salesItemNumber = reader.readLine();
                    System.out.print("Məhsulun kodunu daxil edin: ");
                    String code = reader.readLine();

                    store.withdrawProductFromSales(salesNumber, salesItemNumber, code);
                }
                else if(input2 == 3){
                    System.out.print("Satışın nömrəsini daxil edin: ");
                    String salesNumber = reader.readLine();

                    store.withdrawSale(salesNumber);
                }
                else if(input2 == 4){
                    store.returnSales();
                }
                else if(input2 == 5){
                    System.out.println("Başlanğıc tarixin ilini, ayını, gününü əlavə edin: ");
                    System.out.print("il: ");
                    int startYear = Integer.parseInt(reader.readLine());
                    System.out.print("ay: ");
                    int startMonth = Integer.parseInt(reader.readLine());
                    System.out.print("gün: ");
                    int startDay = Integer.parseInt(reader.readLine());
                    Date startDate = new Date(startYear, startMonth, startDay);


                    System.out.println("Son tarixin ilini, ayını, gününü əlavə edin: ");
                    System.out.print("il: ");
                    int endYear = Integer.parseInt(reader.readLine());
                    System.out.print("ay: ");
                    int endMonth = Integer.parseInt(reader.readLine());
                    System.out.print("gün: ");
                    int endDay = Integer.parseInt(reader.readLine());
                    Date endDate = new Date(endYear, endMonth, endDay);

                    store.searchSalesByDateRange(startDate, endDate);

                }
                else if(input2 == 6){
                    System.out.print("Aşağı qiymət sərhəddini daxil edin:");
                    double lowerCost = Double.parseDouble(reader.readLine());
                    System.out.print("Yuxarı qiymət sərhəddini daxil edin:");
                    double higherCost = Double.parseDouble(reader.readLine());

                    store.searchSalesByCostRange(lowerCost, higherCost);

                }
                else if(input2 == 7){
                    System.out.println("Satışın ilini, ayını, gününü daxil edin: ");
                    System.out.print("il: ");
                    int year = Integer.parseInt(reader.readLine());
                    System.out.print("ay: ");
                    int month = Integer.parseInt(reader.readLine());
                    System.out.print("gün: ");
                    int day = Integer.parseInt(reader.readLine());
                    Date date = new Date(year, month, day);

                    store.searchSalesByDate(date);
                }
                else if(input2 == 8){
                    System.out.print("Satışın nömrəsini daxil edin: ");
                    String salesNumber = reader.readLine();

                    store.searchSalesBySaleNumber(salesNumber);

                }
                else exit = true;

            }
            else exit = true;

        }

    }
}
