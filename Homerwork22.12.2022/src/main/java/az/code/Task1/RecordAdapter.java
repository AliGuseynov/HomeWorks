package az.code.Task1;

import az.code.Task1.CarNumber;

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

public class RecordAdapter {
    public static final String EXAMPLE_FILENAME = "exampleText.txt";
    private List<CarNumber> carNumberList = new ArrayList<>();
    private List<Long> intNumberList = new ArrayList<>();
    private List<LocalDateTime> dateList = new ArrayList<>();
    private List<String> freeTextList = new ArrayList<>();

    public List<CarNumber> getCarNumberList() {
        return carNumberList;
    }

    public void setCarNumberList(List<CarNumber> carNumberList) {
        this.carNumberList = carNumberList;
    }

    public List<Long> getIntNumberList() {
        return intNumberList;
    }

    public void setIntNumberList(List<Long> intNumberList) {
        this.intNumberList = intNumberList;
    }

    public List<LocalDateTime> getDateList() {
        return dateList;
    }

    public void setDateList(List<LocalDateTime> dateList) {
        this.dateList = dateList;
    }

    public List<String> getFreeTextList() {
        return freeTextList;
    }

    public void setFreeTextList(List<String> freeTextList) {
        this.freeTextList = freeTextList;
    }

    public void readFileToList(String filePath) throws IOException {
        Files.lines(Path.of(filePath)).forEach(line -> parseLine(line));
        Collections.sort(intNumberList, Collections.reverseOrder());
        Collections.sort(freeTextList, Collections.reverseOrder());
        Collections.sort(carNumberList);
        Collections.sort(dateList, Collections.reverseOrder());
    }

    private void parseLine(String line) {
        Pattern intPattern = Pattern.compile("^-?\\d+$");
        LocalDateTime date;
        CarNumber carNumber;
        if(intPattern.matcher(line).matches()){
            intNumberList.add(Long.parseLong(line));
        }else if((carNumber = CarNumber.createCarNumber(line)) != null){
            carNumberList.add(carNumber);
        }else if((date = parseDate(line)) != null){
            dateList.add(date);
        }else{
            freeTextList.add(line);
        }
    }

    private LocalDateTime parseDate(String date) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.uuuu HH:mm:ss");
        LocalDateTime result = null;
        try{
            result = LocalDateTime.parse(date, dateTimeFormatter.withResolverStyle(ResolverStyle.STRICT));
        }catch (DateTimeParseException exp){
        }
        return result;
    }
    public void writeToFile() throws IOException {
        Path filePath = Paths.get(EXAMPLE_FILENAME);
        Files.deleteIfExists(filePath);
        Files.createFile(filePath);
        for (String str : freeTextList) {
            Files.writeString(filePath, str + System.lineSeparator(),
                    StandardOpenOption.APPEND);
        }
    }
}
