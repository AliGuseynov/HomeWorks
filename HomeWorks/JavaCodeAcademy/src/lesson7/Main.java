package lesson7;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        List<Person> personList = new ArrayList<>();
        personList.sort(new PersonComparator());
        Collections.sort(personList, new PersonComparator());

//        Person person = new Person("leyla", "khalilli", 21);
//        Person person1 = new Person("leyla", "hajiyeva", 22);


    }
}
