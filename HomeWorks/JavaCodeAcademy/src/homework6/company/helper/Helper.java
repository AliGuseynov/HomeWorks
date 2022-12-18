package homework6.company.helper;

import java.util.Random;

public class Helper {

    public static int getRandomInteger(int max, int min) {
        return ((int) (Math.random() * (max - min))) + min;
    }

}
