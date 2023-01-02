package az.code.HW12_27_2022.task;

import java.io.*;

public class forReadFile {
    public static void main(String[] args) throws CustomCheckedException {

        BufferedReader bufferedReader = null;

        try {
            String strCurrentLine;

            bufferedReader = new BufferedReader(new FileReader("C:\\CodeAcademyBootCamp\\forException.txt"));

            while ((strCurrentLine = bufferedReader.readLine()) != null) {

                System.out.println(strCurrentLine);

            }

        } catch (IOException e) {
            throw new CustomCheckedException("file tapilmadi");
//        } finally {
//
//            try {
//                if (bufferedReader != null)
//                    bufferedReader.close();
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }
//        }

        }

    }
}
