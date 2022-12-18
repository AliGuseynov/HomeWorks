package homeworks.homework5.task4;

public class Main {
    public static void main(String[] args) {


        Main main = new Main();
        main.getText("leyla,xelilli.?akka21?");

    }

    public void getText(String text) {
        String[] arr = text.split("[ ,.!?]+");
        for (String s : arr) {
            System.out.print(s);

        }
    }
}
