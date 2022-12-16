<<<<<<< HEAD
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        String str = "matata";

        char[] strArr = new char[str.length()];

        for (int i = 0; i < strArr.length; i++)
        {
            strArr[i] = str.charAt(i);
        }

        Scanner inn = new Scanner(System.in);

        char search = inn.next().charAt(0);

        int counter = 0;

        for (int i = 0; i < strArr.length; i++)
        {
            if(search == strArr[i]) counter++;
        }

        System.out.println(counter);
    }
}
=======
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        String str = "matata";

        char[] strArr = new char[str.length()];

        for (int i = 0; i < strArr.length; i++)
        {
            strArr[i] = str.charAt(i);
        }

        Scanner inn = new Scanner(System.in);

        char search = inn.next().charAt(0);

        int counter = 0;

        for (int i = 0; i < strArr.length; i++)
        {
            if(search == strArr[i]) counter++;
        }

        System.out.println(counter);
    }
}
>>>>>>> 91bcfde6ff088c03f7a39087e1ef5fe01b4e1794
