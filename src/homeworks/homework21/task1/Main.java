package homeworks.homework21.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

//        List<Person> personList = List.of(new Person(1, "leyla", "khalilli", "21"),
//                new Person(2, "leyla", "khalilli", "21"),
//                new Person(3, "leyla", "khalilli", "21"));
//
//        test(personList);

        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1, "leyla", "khalilli", "21"));
        personList.add(new Person(2, "nihad", "ahmadov", "23"));
        personList.add(new Person(3, "aysel", "memmedli", "22"));
        personList.add(new Person(4, "ilkin", "recebov", "16"));
        personList.add(new Person(5, "esmer", "suleymanova", "17"));


        List<Person> list = personList.stream().filter(i -> Integer.parseInt(i.getAge()) > 18)
                .collect(Collectors.toList());

        System.out.println("task1= " + list);

        System.out.println("task2= " + sum(personList));
        System.out.println("task3= " + averageSum(personList));

    }


    public static int sum(List<Person> list) {
        return list.stream().filter(i -> Integer.parseInt(i.getAge()) > 18)
                .mapToInt(i -> Integer.parseInt(i.getAge())).sum();
    }

    public static OptionalDouble averageSum(List<Person> list) {
        return list.stream().mapToDouble(i -> Integer.parseInt(i.getAge())).average();
    }


}
