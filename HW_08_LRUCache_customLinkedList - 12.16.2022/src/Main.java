import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {


//        System.out.println(LocalDateTime.now());

//        Task1();

        int[] nums = {2, 7, 11, 15};
        String s = "abcabcbb";

        System.out.println(lengthOfLongestSubstring(s));


//        twoSum(nums, 9);


//        Task2();
    }

    public static void Task1() throws InterruptedException {

        LRUCache cache = new LRUCache<>(3);

        HashMap<String, LocalDateTime> result = cache.printAllDetails();



        cache.addElement("Adieu");
        TimeUnit.SECONDS.sleep(1);

        cache.addElement("Zeit");
        TimeUnit.SECONDS.sleep(1);

        cache.addElement("The unforgiven");
        TimeUnit.SECONDS.sleep(1);

        System.out.println(result.toString());

        cache.getElement(0);

        System.out.println(result.toString());

        cache.addElement("November Rain");
        TimeUnit.SECONDS.sleep(1);

        System.out.println(result.toString());

//        System.out.println(cache.getElement(20));


//        List<String> result = cache.printAll();
//
//        for (String e : result)
//            System.out.println(e);

    }

    public static void Task2() {

        CustomLinkedList<Integer> test = new CustomLinkedList<>();

        for (int i = 0; i < 10; i++)
            test.add(i);


        test.remove(0);

        for (int i = 0; i < test.getSize(); i++)
            System.out.println("i = " + i + " | "+ test.get(i));

//        for (int i = 0; i < test.getSize(); i++)
//            System.out.println(test.find(i + 15));
    }


    public static void twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> numbers = new HashMap<>();

        for (int i = 0; i < nums.length; i++)
            numbers.put(nums[i], i);


        for (int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i];

            if (numbers.containsValue(tmp)) {
                System.out.println(i + " " + numbers.get(tmp));
            }
        }

//        for (int i = 0; i < nums.length; i++)
//            for(int j = i + 1; j < nums.length; j++)
//                if (numbers.get(i) + numbers.get(j) == target)
//                    System.out.println(i + " " + j);


    }

    // ABBA - AB BA
    public static int lengthOfLongestSubstring(String s) {



        return 0;

    }
}