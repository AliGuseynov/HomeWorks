import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Main <T> {
    public static File dir = new File("C:\\Users\\Murad\\Desktop\\Code Academy\\java-lessons\\HomeWork\\HW_10_Files-12.22.2022\\Files\\Task1_Files");
    public static void main(String[] args) throws IOException {

        File detailsFile = new File(dir, "Details.txt");

        HashMap<String, List<String>> files = new HashMap<>();

        BufferedReader reader = new BufferedReader(new FileReader(detailsFile));

        String line = reader.readLine();

        List<String> id = new ArrayList<>();
        List<String> fullNames = new ArrayList<>();
        List<String> dates = new ArrayList<>();
        List<String> carId = new ArrayList<>();

        List<String> text = new ArrayList<>();

        while (line != null) {
            text.add(line);

            line = reader.readLine();
        }

        id = text.stream()
                .filter(x -> x.matches("[0-9]+"))
                .sorted((a, b) -> Integer.parseInt(a) - Integer.parseInt(b) < 0 ? 1 : -1)
                .collect(Collectors.toList());

        fullNames = text.stream()
                .filter(x -> x.matches("[^\\d]+"))
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());

        dates = text.stream()
                        .filter(x -> x.matches("[\\d]{4}-[\\d]{2}-[\\d]{2} [\\d]{2}:[\\d]{2}:[\\d]{2}"))
                        .map(x -> LocalDateTime.parse(x, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                        .sorted(Collections.reverseOrder())
                        .map(String::valueOf)
                        .collect(Collectors.toList());

        carId = text.stream()
                .filter(x -> x.matches("[\\d]{2}[a-zA-Z]{2}[\\d]{3}"))
                .map(a-> a = a.substring(2,4) + a.substring(0,2) + a.substring(4))
                .sorted(Collections.reverseOrder())
                .map(a-> a = a.substring(2,4) + a.substring(0,2) + a.substring(4))
                .collect(Collectors.toList());

        reader.close();

        files.put("Ids", id);
        files.put("full_Name", fullNames);
        files.put("dates", dates);
        files.put("car_ID", carId);

        saveFiles(files);
    }

    public static void saveFiles (HashMap<String, List<String>> files) throws IOException {

        FileWriter writer;

        for (Map.Entry<String, List<String>> s : files.entrySet()) {

            List<String> str = s.getValue();

            File tmpFile = new File(dir + "\\" + s.getKey() + ".txt");
            
            if (tmpFile.createNewFile()) {

                writer = new FileWriter(tmpFile);

                for (String value : str) {
                    writer.write(value + "\n");
                }

            } else {

                writer = new FileWriter(tmpFile);

                for (String value : str) {
                    writer.append(value + "\n");
                }
            }

            writer.close();
        }
    }

}