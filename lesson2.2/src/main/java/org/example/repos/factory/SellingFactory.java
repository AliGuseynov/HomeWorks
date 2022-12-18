package org.example.repos.factory;

import org.example.repos.SellingRepo;
import org.example.repos.impl.SellingMemoryImpl;

public class SellingFactory{
    public static SellingRepo createSellingRepo(String type){
        SellingRepo sellingRepo = null;
        switch (type){
            case "memory": sellingRepo = new SellingMemoryImpl();
                break;
        }
        return  sellingRepo;
    }
}
