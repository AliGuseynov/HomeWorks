package org.example;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String fileName = "data.txt";
        String excelFileName = "excelFile.xlsx";
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Sheet1");
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            Row row = null;
            Cell cell = null;
            ArrayList<String> header = new ArrayList<String>();
            ArrayList<String> clients = new ArrayList<String>();
            ArrayList<String> stores = new ArrayList<String>();
            ArrayList<String> ids = new ArrayList<String>();

            int rowIndex = 0;
            List<String> headsArr = new ArrayList<String>();
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split("[/]");
                if (line.startsWith("id")) {
                    headsArr = Arrays.stream(line.split("/")).toList();
                }
                clients.add(tokens[2]);
                stores.add(tokens[1]);
                ids.add(tokens[0]);
                rowIndex++;
            }
            ids.remove(0);
            List<String> newIds = ids.stream().distinct().collect(Collectors.toList());
            List<String> newStores = stores.stream().distinct().collect(Collectors.toList());
            newStores.remove(0);
            for (int i = 0; i < newStores.size(); i++) {
                row = sheet.createRow(i + 1);
                cell = row.createCell(1);
                cell.setCellValue(newStores.get(i).toString());
                cell = row.createCell(0);
                cell.setCellValue(newIds.get(i).toString());
            }
            clients.remove(0);
            List<String> newClient = clients.stream().distinct().collect(Collectors.toList());
            header.addAll(headsArr);
            header.remove(2);
            header.addAll(newClient);
            row = sheet.createRow(0);
            for (int i = 0; i < header.size(); i++) {
                cell = row.createCell(i);
                cell.setCellValue(header.get(i).toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (FileOutputStream outputStream = new FileOutputStream(excelFileName)) {
            workbook.write(outputStream);
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}