import az.code.models.CarNumber;
import az.code.models.az.code.RecordAdapter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        RecordAdapter adapter = new RecordAdapter();
        adapter.readFileToList("input.txt");
        System.out.println(adapter.getCarNumberList());
        System.out.println(adapter.getDateList());
        System.out.println(adapter.getIntNumberList());
        System.out.println(adapter.getFreeTextList());
        adapter.writeToFile();
    }



}
