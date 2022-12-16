package Homwork1;

import java.math.BigDecimal;

public class Tak2 {
    public static void main(String[] args) {

        int amount=1001;
        int reminder=amount;
        double commision=0;

        if(amount>1000){
            commision=(amount-1000)*0.1;
            reminder=1000;
        }
        if(reminder>500){
            commision=commision+ (reminder-500)*0.07;
            reminder=500;
        }
        if(reminder>100){
            commision=commision+(reminder-100)*0.05;
        }

        BigDecimal bd=BigDecimal.valueOf(commision);
        System.out.println(bd);
    }
}
