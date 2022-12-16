package Homework2;

public class Task7 {
    public static void main(String[] args) {
        for (int i=1;i<1000;i++){
            int num=i;
            int sum=0;
            int qaliq=0;
            while (num>0){
                qaliq=num%10;
                num/=10;
                sum+=qaliq;
            }
            if(sum%3==0 && i%10!=3){
                System.out.println(i);
            }
        }
    }
}
