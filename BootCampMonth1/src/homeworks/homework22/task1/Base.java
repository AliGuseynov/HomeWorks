package homeworks.homework22.task1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class Base {
    private static final String forCarNumber = "forCarNumbers.txt";
    private static final String forDateFile = "forDateFile.txt";
    private static final String forIntFile = "forIntFile.txt";
    private static final String forStringFile = "forStringFile.txt";

    private List<CarNumbers> carNumbersList = new ArrayList<CarNumbers>();
    private List<LocalDateTime> dateTimeList = new ArrayList<>();
    private List<String> stringList = new ArrayList<>();
    private List<Long> intList = new ArrayList<>();

    public List<CarNumbers> getCarNumbersList() {
        return carNumbersList;
    }

    public void setCarNumbersList(List<CarNumbers> carNumbersList) {
        this.carNumbersList = carNumbersList;
    }

    public List<LocalDateTime> getDateTimeList() {
        return dateTimeList;
    }

    public void setDateTimeList(List<LocalDateTime> dateTimeList) {
        this.dateTimeList = dateTimeList;
    }

    public List<String> getStringList() {
        return stringList;
    }

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }

    public List<Long> getIntList() {
        return intList;
    }

    public void setIntList(List<Long> intList) {
        this.intList = intList;
    }


    public LocalDateTime parseDate(String date) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.uuuu HH:mm:ss");
        LocalDateTime result = null;
        try {
            result = LocalDateTime.parse(date, dateTimeFormatter.withResolverStyle(ResolverStyle.STRICT));
        } catch (DateTimeParseException exp) {
        }
        return result;
    }


    public void parseLine(String line) {
        Pattern pattern = Pattern.compile("^-?\\d+$");
        LocalDateTime dateTime;
        CarNumbers carNumbers;

        if (pattern.matcher(line).matches()) {
            intList.add(Long.parseLong(line));
        } else if ((carNumbers = CarNumbers.createNumber(line)) != null) {
            carNumbersList.add(carNumbers);
        } else if ((dateTime = parseDate(line)) != null) {
            dateTimeList.add(dateTime);
        } else {
            stringList.add(line);
        }

    }


    public void readFile(String file) throws IOException {
        Files.lines(Path.of(file))
                .forEach(line -> parseLine(line));

        Collections.sort(intList, Collections.reverseOrder());
        Collections.sort(stringList, Collections.reverseOrder());
        Collections.sort(dateTimeList, Collections.reverseOrder());
        Collections.sort(carNumbersList);
    }

    public void writeFile() throws IOException {
        Path path = Paths.get(forStringFile);
        Files.deleteIfExists(path);
        Files.createFile(path);
        for (String str : stringList) {
            Files.writeString(path, str + System.lineSeparator(),
                    StandardOpenOption.APPEND);
        }
    }
}
