package az.code.DataToExcel.model;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class CsvToExcel {
    public static List<List<String>> fileReading(String filename) {

        List<List<String>> result = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                result.add(List.of(line.split("\t")));
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return result;
    }

    public static void WriteDataToExcel(List<String> idList, HashMap<String, Store> storeHashMap, List<String> clients) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Store Data");
        sheet.setColumnWidth(0, 3000);
        sheet.setColumnWidth(1, 3000);

        Row header = sheet.createRow(0);

        CellStyle headerStyle = workbook.createCellStyle();

        Cell headerCell = header.createCell(0);
        headerCell.setCellValue("Company");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(1);
        headerCell.setCellValue("Sum Price");
        headerCell.setCellStyle(headerStyle);

        for (int i = 0; i < clients.size(); i++) {

            sheet.setColumnWidth(i + 2, 4500);
            headerCell = header.createCell(i + 2);
            headerCell.setCellValue(clients.get(i));
            headerCell.setCellStyle(headerStyle);
        }

        for (int i = 0; i < idList.size(); i++) {
            String key = idList.get(i);
            CellStyle style = workbook.createCellStyle();
            style.setWrapText(true);

            Store store = storeHashMap.get(key);

            HashMap<String, Double> companiesSold = store.getCompaniesSold();

            Row row = sheet.createRow(i + 1);
            Cell cell = row.createCell(0);
            cell.setCellValue(storeHashMap.get(key).getStoreName());
            cell.setCellStyle(style);

            cell = row.createCell(1);
            cell.setCellValue(String.valueOf(store.getPrice()));
            cell.setCellStyle(style);

            for (int j = 0; j < clients.size(); j++) {
                cell = row.createCell(j + 2);
                if (companiesSold.containsKey(clients.get(j))) {
                    cell.setCellValue(String.valueOf(companiesSold.get(clients.get(j))));
                } else {
                    cell.setCellValue("0");
                }

                cell.setCellStyle(style);
            }

        }

    }

}
