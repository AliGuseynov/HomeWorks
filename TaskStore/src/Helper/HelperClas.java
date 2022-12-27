package helper;

import models.Product;
import models.ProductCategory;
import models.Sale;
import models.SalesItem;

import java.util.*;

public class HelperClas {
    public static List<Product> generateProducts(int count){
        List<Product> products = new ArrayList<>();


        for (int i = 1; i <= count; i++){
            products.add(new Product("product " + i, getRandomDouble(0, 100), ProductCategory.randomProductCategory(), getRandomInteger(1, 1000), UUID.randomUUID().toString()));
        }
        return products;
    }

    public static List<Sale> generateSales(int countSales){
        List<Sale> sales = new ArrayList<>();

        for (int i = 1; i <= countSales; i++){
            Sale sale =  new Sale("sale number " + i, new Date(2022, 12, getRandomInteger(1, 31)));
            int countSaleItems = getRandomInteger(1, 5);
            for (int j = 1; j <= countSaleItems; j++){
                Product product = new Product("product " + j, getRandomDouble(0, 100), ProductCategory.randomProductCategory(), getRandomInteger(1, 1000), UUID.randomUUID().toString());
                SalesItem salesItem = new SalesItem ("No" + j, product, getRandomInteger(1, product.getCount()));
                sale.addSalesItem(salesItem);
            }
            sales.add(sale);
        }
        return sales;
    }

    public static int getRandomInteger(int maximum, int minimum)
    {
        return ((int) (Math.random()*(maximum - minimum))) + minimum;
    }

    public static double getRandomDouble(double min, double max) {
        return Math.round(((new Random().nextDouble() * (max - min)) + min)*100.0)/100.0;
    }
}
