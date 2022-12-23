package org.example.services;

import org.example.repos.ProductRepo;
import org.example.repos.SellingRepo;
import org.example.repos.factory.ProductFactory;
import org.example.repos.factory.SellingFactory;

import java.text.ParseException;

public class SellingService {
    SellingRepo sellingRepo = SellingFactory.createSellingRepo("memory");

    public void createSelling(){
        sellingRepo.createSelling();
    }

    public void deleteSellingByCode(){
        sellingRepo.deleteSellingByCode();
    }
    public void findSellingById(){
        sellingRepo.findSellingById();
    }
    public void giveBackSellingProduct(){
        sellingRepo.giveBackSellingProduct();
    }
    public void printAllSellings(){
        sellingRepo.printAllSellings();
    }

    public void findSellingByDate() throws ParseException {
        sellingRepo.findSellingByDate();
    }
    public void findSellingByTwoDate() throws ParseException {
        sellingRepo.findSellingByTwoDate();
    }
}
