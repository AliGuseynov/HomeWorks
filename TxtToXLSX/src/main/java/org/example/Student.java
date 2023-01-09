package org.example;

public class Student {
    private int id;
    private String name;
    private int count;


    public int getCount() {
        return count;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Student) {
            Student element = (Student) obj;
            if (element != null &&
                    this.id == element.getId()) {
                return true;
            }
        }
        return false;
}

    public void setCount(int count) {
        this.count = count;
    }

    public Student(int id, String name, int count) {
        this.id = id;
        this.name = name;
        this.count = count;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                '}';
    }
}
