package org.example.converter;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.config.Config;
import org.example.entity.Datas;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class ObjectToExcel {



    public static void writeToExcel(String fileName, List<Datas> datasList) throws IOException {
        List<String> rowHead = Config.excelHead(CsvToObject.createClients(fileName));
        Workbook workbook =  new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Sales data");
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 13);
        headerFont.setColor(IndexedColors.RED.getIndex());

        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

        Row headerRow = sheet.createRow(0);

        for (int i = 0 ; i<rowHead.size();i++){
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(rowHead.get(i));
            cell.setCellStyle(headerCellStyle);

        }
        List<List<String>> excelData = Config.excelSheet(datasList,CsvToObject.createClients(fileName));

        int rowNum=1;

        for (List<String> strings : excelData){
            Row row = sheet.createRow(rowNum++);
            for (int i = 0; i<strings.size();i++){
                row.createCell(i).setCellValue(strings.get(i));
            }

        }


        FileOutputStream fileOutputStream = new FileOutputStream(
                "C:\\Users\\user\\IdeaProjects\\CsvToExcel\\src\\main\\sales.xlsx"
        );
        workbook.write(fileOutputStream);
        fileOutputStream.close();
        workbook.close();
        }




}
