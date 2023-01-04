package models;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class FileReader {


    public static void readFile(String fileLocation) {
        File file = new File(fileLocation);
        List<String> companyIds = new ArrayList<>();
        List<String> clients = new ArrayList<>();
        HashMap<String, SaleUnit> sales = new HashMap<>();

        int counter = 0;
        try (Scanner scanner = new Scanner(file);) {
            while (scanner.hasNextLine()){
            String line = scanner.nextLine();
                String[] sArr = line.split("\t");

                if (counter != 0){
                    HashMap<String, Double> saleData = new HashMap<>();
                    if (!clients.contains(sArr[2])){
                        clients.add(sArr[2]);
                    }
                    if (sales.containsKey(sArr[0])){

                        SaleUnit saleUnit = addSaleToList(sales.get(sArr[0]), sArr);
                        sales.put(sArr[0], saleUnit);

                    } else {
                        companyIds.add(sArr[0]);
                        saleData.put(sArr[2], Double.valueOf(sArr[5]));
                        sales.put(sArr[0], new SaleUnit(Long.parseLong(sArr[0]), sArr[1], Double.parseDouble(sArr[5]), saleData));
                    }


                }
                counter++;
            }


//            companyIds.forEach(a -> System.out.println(sales.get(a)));
//            clients.forEach(System.out::println);

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Sales calculated..");
        FileWriter.exportXLSX(companyIds,sales,clients);
    }

    private static SaleUnit addSaleToList(SaleUnit saleUnit, String [] sArr){

        HashMap<String, Double> companiesSold = saleUnit.getCompaniesSold();

        saleUnit.setSale(saleUnit.getSale() + Double.parseDouble(sArr[5]));

        if (companiesSold.containsKey(sArr[2])){
            saleUnit.getCompaniesSold().put(sArr[2], saleUnit.getCompaniesSold().get(sArr[2]) + Integer.parseInt(sArr[5]));
        } else {
            saleUnit.getCompaniesSold().put(sArr[2], Double.valueOf(sArr[5]));
        }

        return saleUnit;
    }

}
