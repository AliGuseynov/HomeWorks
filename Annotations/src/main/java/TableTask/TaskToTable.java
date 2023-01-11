package TableTask;

import java.io.*;
import java.util.*;

public class TaskToTable {

    static TreeSet<String> clients=new TreeSet<>();
    static HashMap<String, Store> sales = new HashMap<>();
    static List<String> storeIds = new ArrayList<>();

    public static void readFile() {
        String line = "";
        String [] values = null;
        int n=0;
        try {
            BufferedReader br = new BufferedReader(new FileReader("files\\tabledata.txt"));
            int iterator = 0;
            while ((line = br.readLine()) != null) {
                if (iterator == 0) {
                    iterator++;
                    continue;
                }
                if (n!= 0) {
                    HashMap<String, Double> saleData = new HashMap<>();
                    values = line.split("\t");
                    clients.add(values[2]);
                    if (sales.containsKey(values[0])) {
                        Store saleUnit = addSaleToList(sales.get(values[0]), values);
                        sales.put(values[0], saleUnit);
                    }else {
                        storeIds.add(values[0]);
                        saleData.put(values[2], Double.valueOf(values[5]));
                        sales.put(values[0], new Store(Integer.parseInt(values[0]), values[1], Double.parseDouble(values[5]), saleData));
                    }

                }
                n++;

            }
            System.out.println("Sales calculated..");
            ExcelLogic.exportXLSX(storeIds,sales,clients);
        }catch(IOException e){
                e.printStackTrace();
        }
    }

    private static Store  addSaleToList(Store saleUnit, String [] sArr){
        HashMap<String, Double> companiesSold = saleUnit.getMap();
        saleUnit.setPrice(saleUnit.getPrice() + Double.parseDouble(sArr[5]));
        if (companiesSold.containsKey(sArr[2])){
            saleUnit.getMap().put(sArr[2], saleUnit.getMap().get(sArr[2]) + Integer.parseInt(sArr[5]));
        } else {
            saleUnit.getMap().put(sArr[2], Double.valueOf(sArr[5]));
        }
        return saleUnit;
    }
}