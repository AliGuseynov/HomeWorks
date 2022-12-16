package Homwork1;

public class Fib {
    public static void main(String[] args) {
        int num=4;
        int s1=0;
        int s2=1;
        int next;
        for(int i=1;i<=4;i++){//0 1 1 2 3
            System.out.println(s1);
            next=s1+s2;
            s1=s2;
           //2
            s2=next;
        }
    }
}
