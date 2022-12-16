package Homework2;

public class Task1 {
    public static void main(String[] args) {

        for(int i=1;i<1000;i++){//555
            int temp=i;
            int sum=0;
            int qaliq=0;
            while (temp>0){
                qaliq=temp%10;//5
                temp/=10;//55
                sum+=qaliq;//5
            }
            if(sum%5==0 && i%5==0){
                System.out.println(i);
            }
        }

    }

}