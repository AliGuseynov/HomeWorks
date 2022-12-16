package Model;

public class Author {
    String name;
    String nationality;
    int birthYear;

    public Author(String name, String nationality, int birthYear) {
        this.name = name;
        this.nationality = nationality;
        this.birthYear = birthYear;
    }

    public int getBirthYear(){
        return birthYear;
    }
}
