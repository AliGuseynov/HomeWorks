package org.example;
import java.util.List;
import java.util.stream.Collectors;

public class MainForPerson {
    public static void main(String[] args) {
        List<Person> plist=List.of(new Person(1,"Nezrin","Suleymanli","20"),
                new Person(2,"Serxan","Suleymanov","25"),
                new Person(3,"Leyla","Salmanov","40"),
                new Person(4,"Ehmed","Shurukov","19"),
                new Person(5,"Vaqif","Qasimov","30"),
                new Person(6,"Aysu","Xankishizade","16"),
                new Person(7,"Mehriban","Qasimli","13"));
        getOlderThan18(plist);
        getAverAges(plist);
        sumofAgesOlderThan18(plist);
    }
    public static void getOlderThan18(List<Person> list) {
        List<Person> s=list.stream().
                filter(p->Integer.parseInt(p.getAge())>18).
                collect(Collectors.toList());
        System.out.println(s);
    }

    public static void getAverAges(List<Person> list) {
        list.stream().mapToInt(p->Integer.parseInt(p.getAge())).average().
                ifPresent(avg -> System.out.println("Average age is " + avg));
    }

    public static void sumofAgesOlderThan18(List<Person> list) {
       int s= list.stream().
               filter(p->Integer.parseInt(p.getAge())>18).
               mapToInt(p->Integer.parseInt(p.getAge())).
               sum();
        System.out.println("Sum of ages older than 18: "+s);
    }
}


