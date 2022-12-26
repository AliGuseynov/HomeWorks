import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public  class Task1 {
    public static File dir = new File("C:\\Users\\Murad\\Desktop\\Code Academy\\java-lessons\\HomeWork\\HW_11_12.23.2022\\Files");

    public static void run() throws IOException {

        File detailsFile = new File(dir, "Details.txt");
        BufferedReader reader = new BufferedReader(new FileReader(detailsFile));

        JSONObject json = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        List<String[]> text = new ArrayList<>();

        String line = reader.readLine();

        while (line != null) {

            String[] tmp = line.split(",");

            text.add(tmp);

            line = reader.readLine();
        }

        for (String[] s:text) {
            System.out.println(Arrays.toString(s));

            json.put("id", s[0]);
            json.put("fullName", s[1]);
            json.put("DOB", s[2]);
            json.put("class", s[3]);

            jsonArray.put(json);

            try (PrintWriter out = new PrintWriter(new FileWriter(dir + "\\result.json"))) {
                out.append(jsonArray.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
