package TableTask;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import static java.lang.Integer.parseInt;

public class TaskToTable {
    public static void main(String[] args) {
        String path = "C:\\Users\\user\\Desktop\\data.txt";
        String line = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            List<Store> stores=new ArrayList<>();
            List<Store > ss=new ArrayList<>();
            int iterator=0;
            int count=0;
            while ((line = br.readLine()) != null) {
                if (iterator==0){
                    iterator++;
                    continue;
                }
                String [] values = line.split("\t");
                Store store = createStore(values);
                stores.add(store);
            }
            for (int i=0;i<stores.size();i++){
                for (int k=1;k<stores.size();k++){
                    if (stores.get(i).getStoreName().equals(stores.get(k).getStoreName())){
                        ss.add(stores.get(k));
                    }

                }
            }
            System.out.println(ss);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static Store createStore(String[] metadata) {
        String id = metadata[0];
        String storeName = metadata[1];
        String clientName = metadata[2];
        String storePayment = metadata[3];
        String payment = metadata[4];
        String price = (metadata[5]);
        String count = (metadata[1]);
        return new Store(id, storeName, clientName, storePayment, payment, price, count);
    }

}