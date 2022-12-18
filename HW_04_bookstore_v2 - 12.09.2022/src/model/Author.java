package model;

public class Author {
    private String name;
    private String DOB;

    public Author() {
    }
    public Author(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", DOB='" + DOB + '\'' +
                '}';
    }
}
