package operation;

import model.Category;
import model.Product;
import service.ProductService;

import java.util.Scanner;

public class UserOfProducts {
   private static ProductService productService=new ProductService();




    public static void addProductByUser() {

        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);

        System.out.print("Məhsulun adını əlavə edin: ");
        String name = sc.nextLine();
        System.out.print("Qiyməti əlavə edin: ");
        double price = sc1.nextDouble();
        System.out.print("Kateqoria  secin:" +
                "Meyve " + "Yuyucu vasite" + "Ev mehsul" + "Sakalad" + "Icecek");
        String categoryName = sc.nextLine();
        Category category = Category.valueOf(categoryName);
        System.out.print("Sayını əlavə edin: ");
        double count = sc1.nextDouble();
        System.out.println("mehsulun idsini daxil edin");
        String id = sc.nextLine();

        productService.addProduct(new Product(name, price, category, count, id));

    }
    public static void updateProductByUser(){
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);

        System.out.print("Məhsulun yeni adını daxil edin: ");
        String name = sc.nextLine();
        System.out.print("Yeni qiyməti daxil edin: ");
        double price = sc1.nextDouble();
        System.out.print("Kateqoria  secin:" +
                "Meyve " + "Yuyucu vasite" + "Ev mehsul" + "Sakalad" + "Icecek");
        String categoryName = sc.nextLine();
        Category category = Category.valueOf(categoryName);
        System.out.print("Cari sayını daxil edin: ");
        double count = sc1.nextDouble();
        System.out.print("Məhsulun kodunu daxil edin: ");
        String id =sc.nextLine();
        productService.updateProduct(id, name, price, category, count);
    }
    public static void findWithCategoryByUser(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Kateqoria  secin:" +
                "Meyve " + "Yuyucu vasite" + "Ev mehsul" + "Sakalad" + "Icecek");
        String categoryName = sc.nextLine();
        Category category = Category.valueOf(categoryName);
        productService.searchProductsByCategory(category);
    }
    public static void showAllProducts(){
        productService.allProducts();
    }
    public static void findwithRangePriceByUser(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Aşağı qiymət sərhəddini daxil edin:");
        double lowerPrice = sc.nextDouble();
        System.out.print("Yuxarı qiymət sərhəddini daxil edin:");
        double higherPrice = sc.nextDouble();
        productService.searchProductsByPriceRange(lowerPrice, higherPrice);
    }
    public static void findWithProductNameByUser(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Məhsulun adını daxil edin: ");
        String name = sc.nextLine();
        productService.searchProductsByName(name);
    }
    public static void removeProductByUser(){
        Scanner sc=new Scanner(System.in);
        System.out.println("mehsulun idsini daxil edin");
        String id = sc.nextLine();
        productService.deletedProductById(id);
    }
}
