package ui;

import CacheV2.CacheControllerV2;
import cache.CacheController;
import cache.CacheData;
import linkedList.MyLinkedList;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ui {

    CacheController cacheController;
    MyLinkedList myLinkedList;
    CacheControllerV2 cacheControllerV2;

    public Ui(CacheController cacheController, MyLinkedList myLinkedList, CacheControllerV2 cacheControllerV2) {
        this.cacheController = cacheController;
        this.cacheControllerV2 = cacheControllerV2;
        this.myLinkedList = myLinkedList;
    }

    public void run(){

        System.out.print("=============== Avaible options\n" +
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
        System.out.print("=============== Cache controller\n" +
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
        System.out.print("=============== MyLinkedList\n" +
                "1- Add item\n" +
                "2- Get element at index\n" +
                "3- Remove element at index\n" +
                "4- Find item\n" +
                "5- All Items\n" +
                "6- Return\n" +
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
            case "5": getAllItems();
                break;

            case "6": run();
                break;
            default:
                run();
                break;
        }
    }

    public void addElement(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("===============\nEnter value: ");
        String input = scanner.nextLine();
//        cacheController.addData(input);
        cacheControllerV2.addItem(input);
        run();
    }

    public void getElementAtIndex(){

        Scanner scanner = new Scanner(System.in);
        boolean whileBreaker = true;
        while (whileBreaker){

            System.out.print("===============\nEnter index: ");
        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile("^[0-9]*$");
        Matcher matcher = pattern.matcher(input);
        boolean matchFound = matcher.find();
        if(matchFound) {

//            System.out.println(cacheController.getElement(Integer.parseInt(input)));
            System.out.println(cacheControllerV2.getElement(Integer.parseInt(input)));
            whileBreaker = false;
        } }
        run();

    }
    public void printAll(){
//        System.out.println(cacheController.getAll());
        System.out.println(cacheControllerV2.printAll());

        run();

    }

    public void addItem(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("===============\nEnter object: ");
        String input = scanner.nextLine();
        myLinkedList.addItem(input);
        run();
    }
    public void getIndex(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("===============\nEnter index: ");
        boolean whileBreaker = true;
        String input = "-1";
        while (whileBreaker) {
            input = scanner.nextLine();

            if (valideteNumber(input)){
                whileBreaker = false;
            }

        }
        System.out.println(myLinkedList.getElementAtIndex(Integer.parseInt(input)));
        run();

    }
    public void deleteIndex(){

        Scanner scanner = new Scanner(System.in);
        System.out.print("===============\nEnter index: ");
        boolean whileBreaker = true;
        String input = "-1";
        while (whileBreaker) {
            input = scanner.nextLine();

            if (valideteNumber(input)){
                whileBreaker = false;
            }

        }
        System.out.println(myLinkedList.removeIndex(Integer.parseInt(input)) + " Removed");
        run();
    }
    public void findItem(){

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter object: ");
        System.out.println(myLinkedList.findItem(scanner.nextLine()));
        run();

    }

    private boolean valideteNumber(String text){
        Pattern pattern = Pattern.compile("^[0-9_ ]*$");
        Matcher matcher = pattern.matcher(text);
        boolean matchFound = matcher.find();
        if(matchFound) {
            return true;
        } else {
            return false;
        }
    }
    private void getAllItems(){
        myLinkedList.printList();
    }

}
