import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;
import static java.lang.Integer.valueOf;

public class Main {

    public static void main(String[] args) {

        List<Person> persons = List.of(
                new Person(1, "Fuad", "Haciyev", "26"),
                new Person(2, "Murad", "Haciyev", "29"),
                new Person(2, "Ahmed", "Sadixov", "17"),
                new Person(2, "Kamran", "Haciyev", "23"),
                new Person(2, "Vaqif", "Mustafayev", "45"),
                new Person(2, "Vidadi", "Mehdiyev", "14")
        );
        //                Task 1
        persons.stream()
                .filter(person -> parseInt(person.getAge()) > 18)
                .forEach(System.out::println);

        //               Task 2

        var averageAge = persons.stream()
                .map(person -> person.getAge()).mapToInt(Integer::valueOf).average().getAsDouble();

        int value = (int) averageAge;
        System.out.println(value);


//                   Task 3

        var allAgeSum = persons.stream()
         .map(person ->  person.getAge()).mapToInt(Integer::valueOf).filter(ps -> ps >18).sum();
         System.out.println(allAgeSum);

    }
}