package az.code.lessonException;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Person {
    private String name;
    private String surname;

    private Set<String> user = new HashSet<>();


    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person() {
    }


    public void add(String name) throws NameException {
        if (user.contains(name)) {
            throw new NameException("adlar eynidi");
        }
        user.add(name);
        System.out.println(user);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(surname, person.surname);
    }


}
