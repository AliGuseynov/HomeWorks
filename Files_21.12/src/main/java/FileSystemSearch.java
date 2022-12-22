import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class FileSystemSearch {


    public static void run(){
        System.out.print("- What are you searching for? \n- ");
        Scanner scanner = new Scanner(System.in);
        search(scanner.nextLine());
    }
    public static void search(String key){
        File path = new File(XMLtoJson.loadProperties("search_folder"));
        findFiles(path, key);
        run();
    }

    public static void findFiles(File file, String key){
        if (file.isDirectory()){
            Arrays.asList(file.listFiles())
                    .stream()
                    .forEach(a-> search(a, key));
        }
    }

    private static void search(File a, String key) {

        if (a.getName().contains(key)) {
            if (a.isDirectory()){
                System.out.println("Folder : " + a);
            } else {
                System.out.println(a.getName());
            }

        }
            findFiles(a, key);

    }


}
