import java.io.*;

public class Main {
    public static void main(String[] args) {

        Task3();

        Task4();
    }

    //3. try with resourse ile file-i oxuyub setir ve setir chapa verin
    public static void Task3() {

        try {
            File file = new File("input.txt");
//            File file = new File("C:\\Users\\Murad\\Desktop\\Code Academy\\java-lessons\\Practice\\HW_11_12.27.2022\\Files\\input.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

            String line = bufferedReader.readLine();

            while (line != null) {
                System.out.println(line);
                line = bufferedReader.readLine();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    //4. 0-a bolme olarsa handle edin
    public static void Task4() {
        int a = 5;
        int b = 0;

        try {

            System.out.println(a / b);

        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }

// 5. 1 try ichinde bir neche ferqli checked exception atan methodlari chagirin(custom ve IO ) ve ardicilliq ile catch edin
//    logger qoshub, hem file-a hem de console-a log edin

}