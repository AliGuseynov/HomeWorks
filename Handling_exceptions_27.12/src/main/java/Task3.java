import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Task3 {

    public static void run(){

//        File file = new File("files\\textFile.txt");
        File file = new File("textFile"); //File with error

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file));){

                String line = bufferedReader.readLine();

                while (line != null) {
                    System.out.println(line);
                    line = bufferedReader.readLine();
                }

            } catch (IOException e) {
            System.out.println(e.getMessage()); //returns ??? error i don't know how to fix it
            }
    }
}
