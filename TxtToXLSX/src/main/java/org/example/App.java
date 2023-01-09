package org.example;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String args[]) {
        String csvFilePath = "dataCsv.csv";
        try {
            BufferedReader lineRead = new BufferedReader(new FileReader(csvFilePath));
            CSVParser records = CSVParser.parse(lineRead, CSVFormat.EXCEL.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
            Map<Integer, Student> studentMap = new HashMap<Integer, Student>();
            ArrayList<Student> a = new ArrayList<Student>();
            int i = 0;
            for (CSVRecord record : records) {
                Student student = new Student();
                student.setId(Integer.parseInt(record.get(0)));
                student.setName(record.get(1));
                student.setCount(Integer.parseInt(record.get(2)));
                a.add(student);
                i++;

            }
a.stream().forEach(s-> {if(s.getId()==1){
                System.out.println("kjkj");
            }}
            );
            System.out.println(a);
//            for (int i = 0; i < a.size(); i++) {
//                int b=0;
//                if (a.get(i).getId() == studentMap.values().stream().
//                        collect(Collectors.toList()).get(i).getId()) {
//                    studentMap.values().stream().collect(Collectors.toList()).get(b)
//                            .setCount(a.get(i).getCount() +
//                                    studentMap.values().stream().
//                                            collect(Collectors.toList()).get(i).getCount());
//                }
//                System.out.println(studentMap);
//            }
//            System.out.println(studentMap);
//            Collection collection = studentMap.values();
//            Iterator iterator = collection.iterator();
//            int i=0;
//            while (iterator.hasNext() != false) {
//                Student student = (Student) iterator.next();
//                if (student.getId()==a.get(i).getId()) {
//                    int finalI = i;
//                    studentMap.values().stream().map((s)->{
//                        s.setCount(student.getCount()+a.get(finalI).getCount());
//                        return s;
//                    });
////                    System.out.println(studentMap);
//                }
//                i++;
//            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
