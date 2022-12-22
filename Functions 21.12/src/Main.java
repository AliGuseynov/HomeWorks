import functions.Person;
import leetcode.Functions;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class Main {
    public static void main(String[] args) {

        List<Person> people = new ArrayList<>();
        people.add(new Person(1, "Vaqif", "Cavadov", "35"));
        people.add(new Person(2, "Rashad", "Sadiqov", "38"));
        people.add(new Person(3, "Lionel", "Messi", "35"));
        people.add(new Person(3, "Temp", "student", "12"));
        people.add(new Person(3, "Ramiz", "Mammadov", "10"));

        System.out.println("Task 1 ================");
        adults(people);
        System.out.println("Task 2 ================");
        averageAge(people);
        System.out.println("Task 3 ================");
        agesSum(people);
        // task 2
//        int [] nums = {1,2,3,1,1,3};
//        System.out.println("Count of good pairs is: " + Functions.countGoodPairs(nums));

        // task 3
//        Functions.jewelsAndStones("aA", "aAAbbbba");
    }

    public static void adults(List<Person> people){
        people.stream()
                .filter(person -> Integer.parseInt(person.getAge()) > 18)
                .forEach(System.out::println);
    }

    public static void agesSum(List<Person> people){
        Integer count1 = people.stream()
                .map(Person::getAge)
                .map(Integer::valueOf)
                .filter(age -> age > 18)
                .reduce(0, Integer::sum);

        System.out.println("Sum of ages above 18 is " + count1);
    }
    public static void averageAge(List<Person> people){
        double count1 = people.stream()
                .map(Person::getAge)
                .mapToInt(Integer::valueOf)
                .average().getAsDouble();

        System.out.println("Average age is " + count1);
    }
}