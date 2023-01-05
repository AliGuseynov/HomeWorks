package az.code.shopManagement.helper;

import az.code.shopManagement.model.Purchase;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PurchaseGenerator {
    public static String purchaseGenerator(int count){
        List<Purchase> purchases = new ArrayList<>();

        for(int i = 0; i < count; i++){
            Random rd = new Random();
            Purchase purchase = new Purchase();
        }

        return null;
    }
}
