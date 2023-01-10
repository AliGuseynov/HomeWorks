package model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.*;

@Getter
@Setter
@ToString
public class Store {

    private int id;

    private String name;

    private double amount;

    private double percent;

    private Map<String, Double> clients;

    public Store(int id, String name, double percent, double amount) {
        this.id = id;
        this.name = name;
        this.percent = percent;
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Store store = (Store) o;
        return id == store.id && Double.compare(store.percent, percent) == 0 && Objects.equals(name, store.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, percent);
    }
}
