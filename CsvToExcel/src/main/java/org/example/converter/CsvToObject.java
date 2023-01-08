package org.example.converter;

import org.example.entity.Datas;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class CsvToObject {

        public static Set<String> getAllStoreNames(String fileName) throws IOException {
            Set<String> storeList = new HashSet<>();
            Path path = Paths.get(fileName);


            BufferedReader bufferedReader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
            String line = bufferedReader.readLine();

            while (line!=null){
                String[] elements = line.split(",");


                if (storeList.contains(elements[1])){   }
                else {
                    storeList.add(elements[1]);
                }
                line=bufferedReader.readLine();
            }
            return storeList;
        }

        public static Set<String> createClients(String fileName) throws IOException {
            Set<String> clientList = new HashSet<>();
            Path path = Paths.get(fileName);


            BufferedReader bufferedReader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
            String line = bufferedReader.readLine();

            while (line!=null){
                String[] elements = line.split(",");


                if (clientList.contains(elements[2])){   }
                else {
                    clientList.add(elements[2]);
                }
                line=bufferedReader.readLine();
            }
            return clientList;
        }
        private static Datas createDatasFromFile(String[] elements){
            String id = elements[0];
            String storeName = elements[1];
            String clientName= elements[2];
            Double storePercent = Double.parseDouble(elements[3]);
            Double  paymentPercent = Double.parseDouble(elements[4]);
            Double amount = Double.parseDouble(elements[5]);
            int count = Integer.parseInt(elements[6]);

            return new Datas(id,storeName
                    ,clientName,storePercent
                    ,paymentPercent,amount,count);
        }

        public static List<Datas> readAllDatasFromCSV(String fileName) throws IOException {
            List<Datas> datasList = new ArrayList<>();
            Path path = Paths.get(fileName);


            BufferedReader bufferedReader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
            String line = bufferedReader.readLine();

            while (line!=null){
                String[] elements = line.split(",");
                Datas datas = createDatasFromFile(elements);
                datasList.add(datas);
                line=bufferedReader.readLine();
            }
            return datasList;
        }

    }

