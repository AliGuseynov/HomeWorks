package Homwork1;


public class Task3 {
    public static void main(String[] args) {
        int a=5;
        int h=10;
        int s=15;
        int min=0;
        int mid=0;
        int max=0;
        if(a>h && a>s ){
            max=a;
            if(h>s){
                min=s;
                mid=h;
            }else {
                mid=s;
                min=h;
            }
        } else if (h>a && h>s) {
            max=h;
            if(a>s){
               min=s;
               mid=a;
            }else {
                min=a;
                mid=s;
            }

        } else if (s>a && s>h) {
            max=s;
            if (a>h){
                min=h;
                mid=a;
            }else {
                min=a;
                mid=h;
            }
        }

        System.out.println("Maximum"+ max);
        System.out.println("Middle"+ mid);
        System.out.println("Minimum"+ min);
    }
}
