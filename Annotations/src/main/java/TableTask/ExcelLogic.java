package TableTask;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class ExcelLogic {
    public static void exportXLSX(List<String> keys, HashMap<String, Store> sales, TreeSet<String> clients){
        List<String> listclients= new ArrayList<>(clients);

        Workbook workbook = new XSSFWorkbook();

        Sheet sheet = workbook.createSheet("Report");
        sheet.setColumnWidth(0, 3000);
        sheet.setColumnWidth(1, 3000);

        Row header = sheet.createRow(0);

        CellStyle headerStyle = workbook.createCellStyle();

        headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        XSSFFont font = ((XSSFWorkbook) workbook).createFont();
        font.setFontName("Arial");
        font.setFontHeightInPoints((short) 10);
        font.setBold(true);
        headerStyle.setFont(font);

        Cell headerCell = header.createCell(0);
        headerCell.setCellValue("Company");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(1);
        headerCell.setCellValue("Sale count");
        headerCell.setCellStyle(headerStyle);

        for (int i = 0; i < clients.size(); i++){

            sheet.setColumnWidth(i+2, 4500);
            headerCell = header.createCell(i+2);
            headerCell.setCellValue(listclients.get(i));
            headerCell.setCellStyle(headerStyle);
        }




        for (int i = 0; i < keys.size(); i++){
            String key = keys.get(i);
            CellStyle style = workbook.createCellStyle();
            style.setWrapText(true);

            Store sale = sales.get(key);

            HashMap<String, Double> companiesSold = sale.getMap();

            Row row = sheet.createRow(i+1);
            Cell cell = row.createCell(0);
            cell.setCellValue(sales.get(key).getClientName());
            cell.setCellStyle(style);

            cell = row.createCell(1);
            cell.setCellValue(String.valueOf(sale.getPrice()));
            cell.setCellStyle(style);

            for (int j = 0; j < clients.size(); j++){
                cell = row.createCell(j+2);
                if (companiesSold.containsKey(listclients.get(j))){
                    cell.setCellValue(String.valueOf(companiesSold.get(listclients.get(j))));
                } else {
                    cell.setCellValue("-");
                }

                cell.setCellStyle(style);
            }

        }

        File currDir = new File("files\\report.xlsx");
        String path = currDir.getAbsolutePath();
        String fileLocation = "files\\report.xlsx";

        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(fileLocation);
            workbook.write(outputStream);
            workbook.close();
            System.out.println("\nReport exported");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


        

    }
}
