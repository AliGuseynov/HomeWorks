package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<String> nameList=new ArrayList<>();
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        int a=0;
        while (a<5){
            try{
                System.out.println("Enter : ");
                addName(sc.nextLine());
            }catch (CustomException e){
                System.out.println("exist");
            }
            a++;
        }
        System.out.println(nameList);
    }
    public static void addName(String name) throws CustomException {
        if (nameList.contains(name)){
            throw new CustomException("Already exist");
        }
        nameList.add(name);
    }
}