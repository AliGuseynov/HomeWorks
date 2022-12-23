package org.example.repos;

import java.text.ParseException;

public interface SellingRepo  {
    void createSelling();
    void giveBackSellingProduct();
    void deleteSellingByCode();
    void printAllSellings();
    void findSellingByDate() throws ParseException;
    void findSellingByTwoDate() throws ParseException;
    void findSellingById();
}
