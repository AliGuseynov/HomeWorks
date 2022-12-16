package Model;

public class Publisher {

    String name;
    String country;
    boolean active;

    public Publisher(String name, String country, boolean active) {
        this.name = name;
        this.country = country;
        this.active = active;
    }

    @Override
    public String toString() {
        return name;
    }
}
