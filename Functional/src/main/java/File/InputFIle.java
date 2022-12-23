package File;

import java.io.Serializable;
import java.time.LocalDate;

public class InputFIle implements Serializable {
    private int id;
    private String name;
    private String surname;
    private LocalDate date;
    private String carNumber;

    public InputFIle() {
    }

    public InputFIle(int id, String name, String surname, LocalDate date, String carNumber) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.date = date;
        this.carNumber = carNumber;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    @Override
    public String toString() {
        return "InputFIle{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", date=" + date +
                ", carNumber='" + carNumber + '\'' +
                '}';
    }
}
