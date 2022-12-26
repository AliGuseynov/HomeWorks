import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Task1 {
    public static void task1() throws Exception {
        File f = new File("C:\\TestTask\\File.txt");
        Scanner s = new Scanner(f);
        String number;
        String soz = s.next();


        while (s.hasNext()) {
            if (s.hasNext() && soz.matches("[0-9]+")) {
                try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\TestTask\\Number.txt", true))) {
                    bw.write(soz);
                }
                soz = s.next();
            }

            if (soz.matches("^[a-zA-Z]*$") && s.hasNext()) {
                try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\TestTask\\String.txt", true))) {
                    bw.write(soz);
                }
                soz = s.next();
            }

            if (soz.matches("(0?[1-9]|[12][0-9]|3[01]).(0?[1-9]|1[012]).((?:19|20)[0-9][0-9])") && s.hasNext()) {
                try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\TestTask\\Date.txt", true))) {
                    bw.write(soz);
                    soz = s.next();
                }
            }
            if (soz.matches("(2[0-3]|[01][0-9]):[0-5][0-9]:[0-5][0-9]") && s.hasNext()) {
                try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\TestTask\\Date.txt", true))) {
                    bw.write(soz);
                    soz = s.next();
                }

            } else if (soz.matches("[0-9][0-9][A-Z][A-Z][0-9][0-9][0-9]") && s.hasNext()) {
                try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\TestTask\\AvtomobilFile.txt", true));) {
                    String birinci = soz.replaceAll("[^A-Za-z]", "");
                    String ikinci = soz.replaceAll("[^0-9]", "");
                    bw.write(birinci);
                    bw.write(ikinci);
                    soz = s.next();
                }
            }

            if (!s.hasNext() && soz.matches("[0-9]+")) {
                try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\TestTask\\Number.txt", true));) {
                    bw.write(soz);
                }

            }
            if (!s.hasNext() && soz.matches("^[a-zA-Z]*$")) {
                try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\TestTask\\String.txt", true))) {
                    bw.write(soz);
                }

            }
            if (!s.hasNext() && soz.matches("(0?[1-9]|[12][0-9]|3[01]).(0?[1-9]|1[012]).((?:19|20)[0-9][0-9])")) {
                try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\TestTask\\Date.txt", true))) {
                    bw.write(soz);
                }

            }
            if (!s.hasNext() && soz.matches("(2[0-3]|[01][0-9]):[0-5][0-9]:[0-5][0-9]")) {
                try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\TestTask\\Date.txt", true));) {
                    bw.write(soz);
                }

            }
            if (!s.hasNext() && soz.matches("[0-9][0-9][A-Z][A-Z][0-9][0-9][0-9]")) {
                try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\TestTask\\AvtomobilFile.txt", true));) {
                    String birinci = soz.replaceAll("[^A-Za-z]", "");
                    String ikinci = soz.replaceAll("[^0-9]", "");
                    bw.write(birinci);
                    bw.write(ikinci);
                    bw.close();
                }

            }


        }
    }
}
