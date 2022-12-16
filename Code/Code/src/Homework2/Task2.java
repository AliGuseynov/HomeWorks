package Homework2;

public class Task2 {//duzelt(4teklikdir falan bunlarida cixart)
    public static void main(String[] args) {
        int num=12345;
        int temp=num;
        int number=0;
        while (temp>0){
            temp/=10;
            number++;
        }
        System.out.println(number);
    }


}
