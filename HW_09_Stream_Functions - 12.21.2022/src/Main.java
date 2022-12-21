import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
//        Task1();

//        System.out.println(numIdenticalPairs(new int[]{1, 1, 1, 1}));

        System.out.println(numJewelsInStones("aA", "aAAbbbb"));
    }


    public static void Task1() {

        List<Person> personList = new ArrayList<>();

        personList.add(new Person("Murad", "Alishov", "24"));
        personList.add(new Person("Farid", "Mammedov", "17"));
        personList.add(new Person("Nahid", "Abdullayev", "30"));
        personList.add(new Person("Lala", "Aliyeva", "10"));
        personList.add(new Person("Orkhan", "Huseynov", "29"));

//      1. Yaşı 18-dən böyükləri çapa verin

        personList.stream()
                .filter(e -> Integer.parseInt(e.getAge()) > 18)
                .forEach(System.out::println);

//      2. Orta yaşı hesablayın

        int sum = personList.stream()
                .mapToInt(num -> Integer.parseInt(num.getAge()))
                .sum();

        long count = personList.stream()
                .count();

        double avg = personList.stream()
                .mapToDouble(num -> Double.parseDouble(num.getAge()))
                .average()
                .orElse(Double.NaN);

        System.out.println("Sum " + sum);
        System.out.println("Count " + count);
        System.out.println("Avg " + avg);

        //3. Yaşı 18-dən böyük olanların yaşının cəmini hesablayın

        sum = personList.stream()
                .filter(x -> Integer.parseInt(x.getAge()) > 18)
                .mapToInt(x -> Integer.parseInt(x.getAge())).sum();

        System.out.println("SUM " + sum);
    }

    // Task 2
    public static int numIdenticalPairs(int[] nums) {

        int count = 0;

        HashMap<Integer, Integer> pairs = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (pairs.containsKey(nums[i])) {

                int tmp = pairs.get(nums[i]) + 1;

                count += tmp;

                pairs.put(nums[i], tmp);
            } else {
                pairs.put(nums[i], 0);
            }
        }
        return count;
    }

    // Task 3
    public static int numJewelsInStones(String jewels, String stones) {

        HashMap<Character, Integer> jewel = new HashMap<>();
        int sum = 0;

        for (int i = 0; i < jewels.length(); i++)
            jewel.put(jewels.charAt(i), 0);

        for (int i = 0; i < stones.length(); i++) {
            if (jewel.get(stones.charAt(i)) != null)
                sum++;
        }

//        int count = stones.replaceAll("[^" + jewels + "]", "").length();
//        System.out.println("Count #2 " + count);

        return sum;
    }
}