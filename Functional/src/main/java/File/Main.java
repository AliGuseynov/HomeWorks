package File;

public class Main {
    public static void main(String[] args) {
        System.out.println(recursive(235));
    }
    public static int recursive(int num){
        int d;
        if (num/10<10){
            return num/10;
        }else {
            num=recursive(num);
             num=num/10;
            d=num%10;
            return d*10+num;
        }
    }
//    public static int powerofThree(int n) {
//        int num=0;
//        int count=0;
//        if(n!=0){
//            while(num==0){
//                if(n==1){
//                    break;
//                }
//                num=n%3;
//                n=n/3;
//                count++;
//            }
//        }else if (n==0){
//            count=1;
//        }
//        return count;
//    }
}
