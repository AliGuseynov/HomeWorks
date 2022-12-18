package homeworks.homework6.company.helper;

public class Helper {

    public static int getRandomInteger(int max, int min) {
        return ((int) (Math.random() * (max - min))) + min;
    }

}
