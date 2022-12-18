import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

//        Task2();




    }

    public static void Task2() {

        CustomLinkedList<Integer> test = new CustomLinkedList<>();

        for (int i = 0; i < 10; i++)
            test.add(i + 10);


        for (int i = 0; i < test.getSize(); i++)
            System.out.println("i = " + i + " | "+ test.get(i));

        for (int i = 0; i < test.getSize(); i++)
            System.out.println(test.find(i + 15));
    }
}