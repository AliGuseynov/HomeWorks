package Classes;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyMath {

    public static String add(String arg1, String arg2){
        String sum = "";

        Pattern pattern = Pattern.compile("[^0-9]");
        Matcher matcher1 = pattern.matcher(arg1);
        Matcher matcher2 = pattern.matcher(arg2);

        if (arg1.length() < arg2.length()){
            String tempArg = arg2;
            arg2 = arg1;
            arg1 = tempArg;
        }


        boolean matchFound1 = matcher1.find();
        boolean matchFound2 = matcher2.find();

        String [] numArray1;
        String [] numArray2;



        if (!matchFound1 && !matchFound2){

            numArray1 = arg1.split("");
            numArray2 = arg2.split("");
            int tempInMemory = 0;
            int tempSum = 0;
            int n = numArray1.length - numArray2.length;
            for (int i = numArray1.length-1; i > -1; i--){

                int tempId = i-n;

                if (tempId < numArray2.length && tempId>=0) {
                tempSum = Integer.parseInt(numArray1[i])+ Integer.parseInt(numArray2[tempId]) + tempInMemory;
                tempInMemory = tempSum/10;
                tempSum = tempSum%10;

                sum = tempSum + sum;

                }
                else {
                    tempSum = Integer.parseInt(numArray1[i])+ tempInMemory;
                    tempInMemory = tempSum/10;
                    tempSum = tempSum%10;

                    sum = tempSum + sum;

                }
                }

            if (tempInMemory!= 0){
                sum = tempInMemory + sum;
            }


        } else if (matchFound1) {
            throw new RuntimeException("argument one is not a number");
        }else{
            throw new RuntimeException("argument two is not a number");
        }



        return sum;
    }


    public static String multiply(String arg1, String arg2){
        String mult = "0";

        Pattern pattern = Pattern.compile("[^0-9]");
        Matcher matcher1 = pattern.matcher(arg1);
        Matcher matcher2 = pattern.matcher(arg2);

        if (arg1.length() < arg2.length()){
            String tempArg = arg2;
            arg2 = arg1;
            arg1 = tempArg;
        }


        boolean matchFound1 = matcher1.find();
        boolean matchFound2 = matcher2.find();

        String [] numArray1;
        String [] numArray2;



        if (!matchFound1 && !matchFound2){

            List <String> numbersList = new ArrayList<String>();

            numArray1 = arg1.split("");
            numArray2 = arg2.split("");

            String zerosCounter = "";
            for (int i = numArray2.length-1; i > -1; i--){

                String tempMult = "";
                String localZeros = "";
                int tempArg1 = Integer.parseInt(numArray2[i]);



                for (int j = numArray1.length-1; j > -1; j--){



                    if (tempArg1 * Integer.parseInt(numArray1[j]) != 0){
                        numbersList.add(Integer.toString(tempArg1 * Integer.parseInt(numArray1[j]))
                                + zerosCounter + localZeros);


                    }


                    localZeros += "0";


                }
                zerosCounter += "0";
            }
            for (int a = 0; a < numbersList.size();a++){

                String temp1 = numbersList.get(a);
                mult = add(mult, temp1);

            }

        } else if (matchFound1) {
            throw new RuntimeException("argument one is not a number");
        }else{
            throw new RuntimeException("argument two is not a number");
        }



        return mult;
    }
}
