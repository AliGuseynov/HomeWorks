package FileTask.Task1;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Task1Teach {
    public static void main(String[] args) {
        List cars= Arrays.asList(new CarNum(10, "AA", 211),//List of belede gede gede sort edir deye sort ede bilmir
                new CarNum(11, "AB", 245),
                new CarNum(10, "AA", 278));
        Collections.sort(cars);
        System.out.println(cars);
    }
}
