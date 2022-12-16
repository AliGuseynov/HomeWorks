import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args){
//        Task1();
//            Task2(123456);
//                Task3(21312);
//                    Task4(new int[]{10,23,2,45,7} );
//                        Task5(153613236 );
//                            Task6();
}

    public static void Task1(){

        for (int i = 1; i <=1000; i++ ){
            if (i%5 == 0){
                System.out.println(i);
            }
        }
    }

    public static void Task2(int number){

        int workNumber = number;
        int level = 0;
        while (number>0){
            level++;

            switch (level){
                case 1:
                    System.out.println(number%10 + " təklık");
                    break;
                case 2:
                    System.out.println(number%10 + " onluq");
                    break;
                case 3:
                    System.out.println(number%10 + " yüzlük");
                    break;
                case 4:
                    System.out.println(number%10 + " minlik");
                    break;
                case 5:
                    System.out.println(number%10 + " on minlik");
                    break;
                case 6:
                    System.out.println(number%10 + " yüz minlik");
                    break;
            }

            number/=10;
        }
        System.out.println("\n" +level + " mərtəbəli");

    }

    public static void Task3(int number){
        int numBackward = 0;
        int numberStart = number;

        while (number>=1){
            if (number%10 > 0){
                numBackward = numBackward * 10 + (number%10 * 10);
            } else {
                numBackward = numBackward*10 + 10;
            }
            number = number/10;
        }
        numBackward = numBackward/10;

        System.out.println(numBackward == numberStart);

    }

    public static void Task4(int [] numbers){
        int max = 0;

        for (int i = 0; i < numbers.length; i++){
            if (numbers[i] > max){
                max = numbers[i];
            }
        }
        System.out.println(max);
    }


    public static void Task5(int number){
        boolean found = false;
        int foundNumber = 0;
        int tempNumber = number;

        while (!found && tempNumber>0){
            int workNumber = tempNumber%10;
            int tempNumber2 = tempNumber;
            while (!found && tempNumber2>0){
                if (workNumber == tempNumber2%10){
                    found = true;
                    foundNumber = workNumber;

                }
                tempNumber2/=10;
            }

            tempNumber/=10;

        }


        if (found){
            System.out.println(found + " Tekrarlanan reqem " + foundNumber);

        } else {
            System.out.println(found);
        }
    }

    public static boolean arrayContains(int [] inputArray, int value){

        for (int i=0; i<inputArray.length; i++){
            if (inputArray[i] == value){
                return true;
            }
        }
        return false;
    }

    public static void Task6()
    {
        for (int i = 1; i <= 1000; i++){

            if (i%10 != 3){
                int sum = 0;
                int temp = i;
                while (temp >0) {
                sum = sum + temp%10;
                temp = temp/10;
                }
                if (sum%3 == 0) {
                    System.out.println(i);
                }
            }

            }
        }
    }


