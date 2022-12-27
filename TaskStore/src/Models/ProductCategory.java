package models;

import java.util.Random;

public enum ProductCategory {
    Bakery,
    Beverage,
    Nonfood,
    Pharmacy,
    Meat,
    Seafood;

    private static final Random PRNG = new Random();

    public static ProductCategory randomProductCategory(){
        ProductCategory[] productCategories = values();
        return productCategories[PRNG.nextInt(productCategories.length)];
    }
}




