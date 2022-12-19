package ui;

import cache.CacheController;
import cache.CacheData;
import linkedList.MyLinkedList;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ui {

    CacheController cacheController;
    MyLinkedList myLinkedList;

    public Ui(CacheController cacheController, MyLinkedList myLinkedList) {
        this.cacheController = cacheController;
        this.myLinkedList = myLinkedList;
    }

    public void run(){

        System.out.print(" Avaible options\n" +
                "1- Cache controller\n" +
                "2- MyLinkedList" +
                "Enter option: ");
        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();

        switch (option){
            case "1": RenderCacheController();
                break;
            case "2": RenderLinkedList();
                break;
            default:
                run();
                break;
        }
    }

    private void RenderCacheController(){
        System.out.print(" Cache controller\n" +
                "1- Add element\n" +
                "2- Get element at index\n" +
                "3- Print all\n" +
                "4- Return\n" +
                "Enter option: ");
        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();

        switch (option){
            case "1": addElement();
                break;
            case "2": getElementAtIndex();
                break;
            case "3": printAll();
                break;
            case "4": run();
                break;
            default:
                run();
                break;
        }
    }

    private void RenderLinkedList(){
        System.out.print(" MyLinkedList\n" +
                "1- Add item\n" +
                "2- Get element at index\n" +
                "3- Remove element at index\n" +
                "4- Find item\n" +
                "5- Return\n" +
                "Enter option: ");
        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();

        switch (option){
            case "1": addItem();
                break;
            case "2": getIndex();
                break;
            case "3": deleteIndex();
                break;
            case "4": findItem();
                break;
            case "5": run();
                break;
            default:
                run();
                break;
        }
    }

    public void addElement(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter value");
        String input = scanner.nextLine();
        cacheController.addData(input);
        run();
    }

    public void getElementAtIndex(){

        Scanner scanner = new Scanner(System.in);
        boolean whileBreaker = true;
        while (whileBreaker){

            System.out.print("Enter index");
        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile("^[0-9]*$");
        Matcher matcher = pattern.matcher(input);
        boolean matchFound = matcher.find();
        if(matchFound) {

            System.out.println(cacheController.getElement(Integer.parseInt(input)));
            whileBreaker = false;
        } }
        run();

    }
    public void printAll(){
        System.out.println(cacheController.getAll());
        run();

    }

    public void addItem(){

    }
    public void getIndex(){

    }
    public void deleteIndex(){

    }
    public void findItem(){

    }

}
