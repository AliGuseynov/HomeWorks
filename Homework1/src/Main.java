import java.math.BigDecimal;
import java.util.Arrays;
public class Main {
    public static void main(String[] args){

//        Task1(14);
        Task2(1000);
//        Task3(24,20,54);
//        Task4(4, 800, false, true);
    }

    private static void Task1(int month){

        if (month>= 1 && month <=12){
            switch (month){
                case 1:
                    System.out.println("Yanvar");
                    break;
                case 2:
                    System.out.println("Fevral");
                    break;
                case 3:
                    System.out.println("Mart");
                    break;
                case 4:
                    System.out.println("Aprel");
                    break;
                case 5:
                    System.out.println("May");
                    break;
                case 6:
                    System.out.println("Iyun");
                    break;
                case 7:
                    System.out.println("Iyul");
                    break;
                case 8:
                    System.out.println("Avqust");
                    break;
                case 9:
                    System.out.println("Sentyabr");
                    break;
                case 10:
                    System.out.println("Oktyabr");
                    break;
                case 11:
                    System.out.println("Noyabr");
                    break;
                case 12:
                    System.out.println("Dekabr");
                    break;

            }}
        else System.out.println("Number is not in range");

    }

    private static void Task2(float input){
        double percent = 0;

        int scenario;

        if (input > 500){
            scenario = 3;
        }else{ if (input > 100){
            scenario = 2;

        } else {
            scenario = 1;}
        }

        BigDecimal temp = new BigDecimal(input);

        BigDecimal one = new BigDecimal(input);
        BigDecimal two = new BigDecimal(100);
        BigDecimal result1 = one.subtract(two);
        BigDecimal tree = new BigDecimal(5);
        BigDecimal result2 = result1.multiply(tree);
        BigDecimal result3 = result2.divide(two);


        switch (scenario){
            case 1:
                System.out.println("Əlavəniz 0 AZN təşkil edir");
            break;
            case 2:
                System.out.println("Əlavəniz " + result3 +" AZN təşkil edir");
            break;
            case 3:


                 BigDecimal four = new BigDecimal(500);
                 BigDecimal result4 = one.subtract(four);
                 BigDecimal five = new BigDecimal(7);
                 BigDecimal result5 = result4.multiply(five);

                 BigDecimal result6 = result5.divide(two);
                 BigDecimal staticpercent = new BigDecimal(25);
                 BigDecimal sumfinal = result6.add(staticpercent);

                System.out.println("Əlavəniz " + sumfinal +" AZN təşkil edir");
            break;

        }



    }

    public static void Task3(int n1, int n2, int n3){
        int asimanAge = n1;
        int hasanAge = n2;
        int shamsAge = n3;

        int ages[] = {n1,n2,n3};

        int min = n1;
        int mid = n1;
        int max = 0;

        for (int i = 0; i<ages.length; i++) {

            if (ages[i]<min){
                min = ages[i];
            }
            if (ages[i]> max){
                max = ages[i];
            }
        }
        for (int i = 0; i<ages.length; i++){
            if(ages[i]> min && ages[i]<max){
                mid = ages[i];
            }
        }


        System.out.println(min + " " + mid + " " + max);
    }

    public static void Task4(int speedInput, int wehtghtInput, boolean modeInput, boolean stuckImput){
        boolean autoMode = modeInput; //true if auto
        int speedMode = speedInput; // 0- stopped; 1..4 movement speed
        int weight = wehtghtInput;
        boolean stuck = stuckImput;


        int tempspeed = speedMode; // yenidən işə salınması, taskda bu göstərilməmişdir, bilmədim nə dərəcədə lazımlıdır

        if(autoMode){
            if (weight == 0 || stuck) {
                speedMode = 0;
            } else if (weight <= 300) {
                speedMode = 4;
            } else if (weight <= 500) {
                speedMode = 3;
            } else if (weight <= 800) {
                speedMode = 2;
            } else { speedMode = 1;}

        } else{
            if (weight > 1000) {
                speedMode = 0;
            }
            else { speedMode = tempspeed;} //yenidən işə salınması
            }

        System.out.println(speedMode);
        }
    }

