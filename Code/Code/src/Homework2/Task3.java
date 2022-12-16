package Homework2;

public class Task3 {
    public static void main(String[] args) {
        int num=123496;
        int temp=num;
        int qaliq=0;
        int sum=0;
        while (temp>0){
            qaliq=temp%10;
            temp/=10;
            if(qaliq==1){
                sum+=qaliq;
            }
            if (qaliq==2){
                sum+=qaliq;
            }

            if(qaliq==3){
                sum+=qaliq;
            }
            if(qaliq%2!=0 && qaliq!=1){
                sum+=qaliq;
            }
        }
        System.out.println(sum);
    }
}
