package TableTask;

import com.opencsv.CSVWriter;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class TaskToTable {
    public static void main(String[] args) {
        String path = "C:\\Users\\user\\Desktop\\dataoftable.txt";
//       Set<String> store=AllStore(path);
//        System.out.println(store);
        Set<String> client=AllClients(path);
//        System.out.println(client);
        List<Store> tt=readAllFromFile(path);
        for (Store t:tt){
            System.out.println(t);
        }


        String line = "";
        String [] values = null;

        Store data=null;
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            int iterator = 0;
            while ((line = br.readLine()) != null) {
                if (iterator == 0) {
                    iterator++;
                    continue;
                }
                values = line.split(",");
                data = Stores(values);
            }
        }catch(IOException e){
                e.printStackTrace();
        }
        List<String> s= ExcelLogic.amountAdder(client,data);
        for (String ss:s){
            System.out.println(ss);
        }

    }
    public static Set<String> AllStore(String path){
        Set<String> stores=new HashSet<>();
        String line = "";
        String [] values = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            int iterator=0;
            while ((line = br.readLine()) != null) {
                if(iterator==0){
                    iterator++;
                    continue;
                }
                values = line.split(",");
                stores.add(values[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stores;
    }

    public static Set<String> AllClients(String path){
        Set<String> clients=new HashSet<>();
        String line = "";
        String [] values = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            int iterator=0;
            while ((line = br.readLine()) != null) {
                if(iterator==0){
                    iterator++;
                    continue;
                }
                values = line.split(",");
                clients.add(values[2]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return clients;
    }

    public static Store Stores(String [] values){
        int  id = Integer.parseInt(values[0]);
        String storeName = values[1];
        String clientName= values[2];
        Double storePercent = Double.parseDouble(values[3]);
        Double  paymentPercent = Double.parseDouble(values[4]);
        Double amount = Double.parseDouble(values[5]);
        int count = Integer.parseInt(values[6]);
        return new Store(id,storeName
                ,clientName,storePercent
                ,paymentPercent,amount,count);
    }


    public static List<Store> readAllFromFile(String path) {
        List<Store> storesList = new ArrayList<>();
        String line = "";
        String [] values = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            int iterator=0;
            while ((line = br.readLine()) != null) {
                if(iterator==0){
                    iterator++;
                    continue;
                }
                values = line.split(",");
                Store data = Stores(values);
                storesList.add(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return storesList;
    }

}