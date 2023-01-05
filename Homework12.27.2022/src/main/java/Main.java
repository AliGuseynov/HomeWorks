import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    //private static Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
//        while(true){
//            try{
//                System.out.println("Enter index:");
//                int index = scan.nextInt();
//                fillArray(index);
//            }catch (CustomRuntimeException e){
//                //logger.warn("Index problem." , e);
//                System.out.println(e);
//            }
//        }

        while(true){
            try{
                System.out.println("Enter divisor");
                int num1 = scan.nextInt();
                System.out.println("Enter divider:");
                int num2 = scan.nextInt();
                divisionChecker(num1,num2);
            }catch (CustomCheckedException e) {
                System.out.println(e);
            }
        }
    }

    public static void fillArray(int index) throws CustomRuntimeException {
        String[] arr = new String[5];
        if(index > arr.length)
            throw new CustomRuntimeException("Index out of bound." , 2);
        else
            arr[index] = "newString";
    }
    public static void divisionChecker(int num1, int num2) throws CustomCheckedException {
        if(num2 == 0)
            throw new CustomCheckedException();
        else
            System.out.println(num1/num2);
    }
}

