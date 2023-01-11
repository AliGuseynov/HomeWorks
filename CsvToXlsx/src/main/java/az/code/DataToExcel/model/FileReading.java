package az.code.DataToExcel.model;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class FileReading {

    private static Store addSaleToList(Store store, String[] sArr) {

        HashMap<String, Double> companiesSold = store.getCompaniesSold();

        store.setSale(store.getSale() + Double.parseDouble(sArr[5]));

        if (companiesSold.containsKey(sArr[2])) {
            store.getCompaniesSold().put(sArr[2], store.getCompaniesSold().get(sArr[2]) + Integer.parseInt(sArr[5]));
        } else {
            store.getCompaniesSold().put(sArr[2], Double.valueOf(sArr[5]));
        }

        return store;
    }


    public static void readFile(String fileLocation) {
        File file = new File(fileLocation);
        List<String> companyIds = new ArrayList<>();
        List<String> clients = new ArrayList<>();
        HashMap<String, Store> stores = new HashMap<>();

        int counter = 0;
        try (Scanner scanner = new Scanner(file);) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] sArr = line.split("\t");

                if (counter != 0) {
                    HashMap<String, Double> storeData = new HashMap<>();
                    if (!clients.contains(sArr[2])) {
                        clients.add(sArr[2]);
                    }
                    if (stores.containsKey(sArr[0])) {

                        Store saleUnit = addSaleToList(stores.get(sArr[0]), sArr);
                        stores.put(sArr[0], saleUnit);

                    } else {
                        companyIds.add(sArr[0]);
                        storeData.put(sArr[2], Double.valueOf(sArr[5]));
                        stores.put(sArr[0], new Store(Long.parseLong(sArr[0]), sArr[1],
                                Double.parseDouble(sArr[5]), storeData));
                    }


                }
                counter++;
            }


        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        CsvToExcel.createExcel(companyIds, stores, clients);
    }


}