package org.example;

import Task1.MyExceptionNullPointer;
import Task1.Person;
import Task2.CheckedException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws CheckedException {
//        Person person= new Person();
//        if(person.name==null){
//            try{
//                throw new MyExceptionNullPointer("error");
//            }catch(NullPointerException ex){
//                ex.printStackTrace();
//            }
//        }
//        try {
//            BufferedReader bf=new BufferedReader(new FileReader("ddkfkf.df"));
//        } catch (FileNotFoundException e) {
//            throw new CheckedException("error");
//        }
        try {
            System.out.println(divided(2, 0));
        } catch (ArithmeticException arithmeticException) {
            LOGGER.error("Loglar",arithmeticException);
        }

    }

    public static double divided(double a, double b) {
        double result = a / b;
        return result;
    }
}