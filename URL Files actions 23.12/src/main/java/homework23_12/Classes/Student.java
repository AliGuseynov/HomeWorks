package homework23_12.Classes;

import java.time.LocalDate;

public final class Student implements Comparable<Student> {

    final int id;
    final String name;
    final String surname;
    final LocalDate birthdate;

    public Student(int id, String name, String surname, LocalDate birthdate) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }

    public String toCSV(){
        return id+","+name+","+surname+","+birthdate+"\n";
    }

    public void printStudent(){
        System.out.println("============Student id-" + id + "\n" +
                                "Name: " + name+ "\n" +
                                "Surname: " + surname + "\n" +
                "Birthdate: " + birthdate + "\n --------------------------" );
    }

    @Override
    public int compareTo(Student o) {
        return 0;
    }
}
