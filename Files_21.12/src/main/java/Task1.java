import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Task1 <T>{

    public static void run(){
        List<String> textList = read();

        List<String> nums = textList.stream()
                .filter(a -> a.matches("-?[0-9]+"))
                .map(Integer::valueOf)
                .sorted(Collections.reverseOrder())
                .map(String::valueOf)
                .collect(Collectors.toList());

        List<String> string = textList.stream()
                .filter(a -> a.matches("[^0-9]+"))
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());

        List<String> date = textList.stream()
                .filter(a -> a.matches("[0-9]{2}.[0-9]{2}.[0-9]{4} [0-9]{2}:[0-9]{2}:[0-9]{2}"))
                .map(a-> LocalDateTime
                        .parse(a, DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")))
                .sorted(Collections.reverseOrder())
                .map(String::valueOf)
                .collect(Collectors.toList());

        List<String> carNumbers = textList.stream()
                .filter(a -> a.matches("[0-9]{2}[A-Z]{2}[0-9]{3}"))
                .map(a-> a = a.substring(2,4) + a.substring(0,2) + a.substring(4))
                .sorted(Collections.reverseOrder())
                .map(a-> a = a.substring(2,4) + a.substring(0,2) + a.substring(4))
                .collect(Collectors.toList());

        writeToFile(nums, "Numbers");
        writeToFile(string, "Strings");
        writeToFile(date, "Dates");
        writeToFile(carNumbers, "Car Numbers");

//        nums.forEach(System.out::println);
//        System.out.println(nums.size());
//        string.forEach(System.out::println);
//        System.out.println(string.size());
//        date.forEach(System.out::println);
//        System.out.println(date.size());
//        carNumbers.forEach(System.out::println);
//        System.out.println(carNumbers.size());
    }


    public static List<String> read(){
        List<String> stringsOut =  new ArrayList<>();
        try {
            File file = new File("files\\info.txt");

            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                stringsOut.add(data);
//                System.out.println(data);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Can't find file");
            e.printStackTrace();
        }
        return stringsOut;
    }


    private static void writeToFile(List<String> list, String filename){
        try {
            FileWriter myWriter = new FileWriter("files\\" + filename +".txt");
            list.forEach(a-> {
                try {
                    myWriter.write(a+"\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            myWriter.flush();
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }


}

