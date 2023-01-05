package csv;

public class Student {
    private String name;
    private int age;
    private String surname;
    private String className;

    public Student() {
    }

    public Student(String name, int age, String surname, String className) {
        this.name = name;
        this.age = age;
        this.surname = surname;
        this.className = className;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", surname='" + surname + '\'' +
                ", className='" + className + '\'' +
                '}';
    }
}
