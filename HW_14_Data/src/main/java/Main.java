import model.Store;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.*;

public class Main {

    public static String input = "data.txt";
    public static String output = "out.xlsx";

    public static void main(String[] args) {

        List<String[]> file;
        Map<Integer, Store> stores;
        Map<String, Double> clients;

        try{

            file = readFile(input);
            clients = getAllClients(file);
            stores = getAllStores(clients, file);
            createExcel(stores, clients);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    public static List<String[]> readFile(String input) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File(input));
        List<String[]> result = new ArrayList<>();

        while (scanner.hasNextLine()) {

            String line = scanner.nextLine();

            result.add(line.split("\t"));
        }

        return result;
    }

    public static Map<String, Double> getAllClients(List<String[]> file) throws IOException {

        Map<String, Double> clients = new HashMap<>();

        for (String[] line : file) {

            if (line[0].matches("[0-9]+")) {
                clients.put(line[2], 0.0);
            }
        }

        return clients;
    }

    public static Map<Integer, Store> getAllStores(Map<String, Double> clients, List<String[]> file) throws IOException {

        Map<Integer, Store> stores = new HashMap<>();

        for (String[] line : file) {

            if (line[0].matches("[0-9]+")) {

                Store store = new Store(Integer.parseInt(line[0]), line[1],
                        Double.parseDouble(line[3]) + Double.parseDouble(line[4]),
                        Double.parseDouble(line[5]) * Integer.parseInt(line[6]));

                if (stores.containsValue(store)) {
                    Store tmpStore = stores.get(store.getId());

                    tmpStore.setAmount(store.getAmount() + tmpStore.getAmount());
                    tmpStore.setClients(getStoreClients(tmpStore.getClients(), line));

                } else {
                    store.setClients(getStoreClients(clients, line));
                    stores.put(store.getId(), store);
                }
            }
        }

        return stores;
    }

    public static Map<String, Double> getStoreClients(Map<String, Double> allClients, String[] saleDetails) {

        Map<String, Double> clients = new HashMap<>(allClients);
//        47	Ali&Nino	Azerconnect-1	7.5	2.5	50.00	1
//        47	Ali&Nino	Azerconnect-3	7.5	2.5	50.00	1
        clients.put(saleDetails[2],
                clients.get(saleDetails[2]) + Double.parseDouble(saleDetails[5]) * Integer.parseInt(saleDetails[6]));

        return clients;
    }

    public static void createExcel(Map<Integer, Store> stores, Map<String, Double> clients) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Sales");

        int rowId = 0;
        Row row = sheet.createRow(rowId++);

        int cellId = 0;
        Cell cell;

        for (String x : setTitle(clients)) {
            cell = row.createCell(cellId++);
            cell.setCellValue(x);
        }

        cellId = 0;

        for (Store e : stores.values()) {
            row = sheet.createRow(rowId++);

            cell = row.createCell(cellId++);
            cell.setCellValue(e.getId());

            cell = row.createCell(cellId++);
            cell.setCellValue(e.getName());

            cell = row.createCell(cellId++);
            cell.setCellValue(e.getPercent());

            cell = row.createCell(cellId++);
            cell.setCellValue(e.getAmount());

            for (Double c : e.getClients().values()) {
                cell = row.createCell(cellId++);
                cell.setCellValue(c);
            }

            cellId = 0;
        }

        FileOutputStream out = new FileOutputStream(output);

        workbook.write(out);
        out.close();
    }

    public static List<String> setTitle(Map<String, Double> clients) throws IOException {

        List<String> title = new ArrayList<>();

        title.add("ID");
        title.add("NAME");
        title.add("ALL%");
        title.add("AMOUNT");

        title.addAll(clients.keySet());

        return title;
    }
}