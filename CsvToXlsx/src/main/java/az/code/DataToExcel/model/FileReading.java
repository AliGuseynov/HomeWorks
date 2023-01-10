package az.code.DataToExcel.model;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FileReading {

    private static Store addPriceToList(Store store, String[] sArr) {

        HashMap<String, Double> companiesSold = store.getCompaniesSold();

        store.setPrice(store.getPrice() + Double.parseDouble(sArr[5]));

        if (companiesSold.containsKey(sArr[2])) {
            store.getCompaniesSold().put(sArr[2], store.getCompaniesSold().get(sArr[2]) + Integer.parseInt(sArr[5]));
        } else {
            store.getCompaniesSold().put(sArr[2], Double.valueOf(sArr[5]));
        }

        return store;
    }

    public static void readFile(String fileName) throws IOException {

        File file = new File(fileName);
        List<String> clients = new ArrayList<>();
        List<String> ids = new ArrayList<>();
        HashMap<String, Store> sales = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = "";

            while ((line = br.readLine()) != null) {
                String[] tempArr = line.split("\t");
                int counter = 0;
                if (counter != 0) {

                    HashMap<String, Double> saleData = new HashMap<>();
                    if (!clients.contains(tempArr[2])) {
                        clients.add(tempArr[2]);
                    }
                    if (sales.containsKey(tempArr[0])) {

                        Store saleUnit = addPriceToList(sales.get(tempArr[0]), tempArr);
                        sales.put(tempArr[0], saleUnit);

                    } else {
                        ids.add(tempArr[0]);
                        saleData.put(tempArr[2], Double.valueOf(tempArr[5]));
                        sales.put(tempArr[0], new Store((int) Double.parseDouble(tempArr[0]), tempArr[1],
                                Double.parseDouble(tempArr[5]), saleData));
                    }


                }
                counter++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        FileWriter.exportXLSX(companyIds, sales, clients);
        CsvToExcel.WriteDataToExcel(ids, sales, clients);
    }
}