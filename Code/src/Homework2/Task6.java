package Homework2;

public class Task6 {
    public static void main(String[] args) {
        int num = 53213;
        int count =0;
        int qaliq=0;
        while (num > 0){
            qaliq=num % 10;//3
            num = num / 10;//12
            int temp = num;
            while (temp > 0){
                if (temp % 10 == qaliq){
                    count=1;
                    System.out.println("false "+qaliq+" tekrarlanir");
                    break;
                }
                temp = temp / 10;
            }
        }
        if (count == 0){
            System.out.println("true");
        }


    }
}
