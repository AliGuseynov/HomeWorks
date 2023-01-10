package TableTask;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ExcelLogic {
    public static List<String> amountAdder(Set<String> clientSet, Store data){
        List<String> amountList = new ArrayList<>();

        for (String client : clientSet){
            if (client.equals(data.getClientName())){
                amountList.add(String.valueOf(data.getPrice()));
            } else { amountList.add("null");}
        }
        return amountList;
    }

//    public static List<String> excelHead(Set<String> clientSet){
//        List<String> rowHead = new ArrayList<>();
//        rowHead.add("ID");
//        rowHead.add("STORE NAME");
//        rowHead.add("PERCENT");
//        rowHead.add("AMOUNT");
//        rowHead.addAll(clientSet);
//        return rowHead;
//    }
//
//
//    public static List<List<String>> excelSheet(List<Datas> datasList,Set<String> clientSet){
//        List<List<String>> result = new ArrayList<>();
//
//        for (int i = 0 ; i<datasList.size();i++){
//            String storeId = datasList.get(i).getId();
//            String storeName = datasList.get(i).getStore();
//            String percent = String.valueOf(datasList.get(i).getPaymentPercent()+datasList.get(i).getStorePercent());
//            Double amount = 0.00;
//            for (Datas datas : datasList){
//                if (datas.getStore().equals(storeName)){
//                    amount=amount+ datas.getAmount();
//                }
//            }
//            String allAmount = String.valueOf(amount);
//
//            List<String> resultInside = new ArrayList<>();
//            resultInside.add(storeId); resultInside.add(storeName); resultInside.add(percent); resultInside.add(allAmount);
//            resultInside.addAll(amountAdder(clientSet,datasList.get(i)));
//            result.add(resultInside);
//        }
//
//        return result;
//    }
}