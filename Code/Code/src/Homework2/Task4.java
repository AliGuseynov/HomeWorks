package Homework2;

public class Task4 {
    public static void main(String[] args) {
        int num=123;
        int newNum=0;
        int temp=num;
        int qaliq=0;
        while (temp>0){
            qaliq=temp%10;
            temp/=10;
            newNum=newNum*10+qaliq;
        }
        if(num==newNum){
            System.out.println("polindrome");
        }else{
            System.out.println("not polindrome");
        }

    }
}
