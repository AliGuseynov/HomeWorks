package Model;

public class Branch {
    Store store;
    String name;
    String location;
    int numberOfEmployees;

    public Branch(Store store, String name, String location, int numberOfEmployees) {
        this.store = store;
        this.name = name;
        this.location = location;
        this.numberOfEmployees = numberOfEmployees;
    }

    @Override
    public String toString() {
        return name;
    }
}
