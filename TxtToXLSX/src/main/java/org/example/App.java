package org.example;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String args[]) {
        String csvFilePath = "dataCsv.csv";
        try {
            BufferedReader lineRead = new BufferedReader(new FileReader(csvFilePath));
            CSVParser records =
                    CSVParser.parse(lineRead, CSVFormat.EXCEL.withFirstRecordAsHeader()
                            .withIgnoreHeaderCase().withTrim());
            Map<Integer, Student> studentMap = new HashMap<Integer, Student>();
            int i = 0;
            for (CSVRecord record : records) {
                Student student = new Student();
                student.setId(Integer.parseInt(record.get(0)));
                student.setName(record.get(1));
                student.setCount(Integer.parseInt(record.get(2)));
                if (!studentMap.containsKey(student.getId())) {
                    studentMap.put(student.getId(), student);
                } else {
                    studentMap.put(student.getId(), new Student(student.getId(), student.getName(),
                            student.getCount() + studentMap.get(student.getId()).getCount()));
                }
                i++;

            }
            String excelFileName = "excelFile.xlsx";
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Sheet1");
            String line;
            Row row = null;
            Cell cell = null;
            for (int a = 0; a < studentMap.size(); a++) {
                row = sheet.createRow(0);
                cell = row.createCell(0);
                cell.setCellValue("id");
                cell = row.createCell(1);
                cell.setCellValue("name");
                cell = row.createCell(2);
                cell.setCellValue("count");
                row = sheet.createRow(a+1);
                cell = row.createCell(0);
                cell.setCellValue(Integer.valueOf(studentMap.get(a+1).getId()));
                cell = row.createCell(1);
                cell.setCellValue(studentMap.get(a+1).getName());
                cell = row.createCell(2);
                cell.setCellValue(Integer.valueOf(studentMap.get(a+1).getCount()));
            }
            try (FileOutputStream outputStream = new FileOutputStream(excelFileName)) {
                workbook.write(outputStream);
                workbook.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
