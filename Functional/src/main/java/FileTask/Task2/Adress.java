package FileTask.Task2;

import java.time.LocalDateTime;

public class Adress {
    private int id;
    private String street;
    private String city;

    public Adress() {
    }

    public Adress(int id, String streat, String city) {
        this.id = id;
        this.street = streat;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreat() {
        return street;
    }

    public void setStreat(String streat) {
        this.street = streat;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    @Override
    public String toString() {
        return "Adress{" +
                "id=" + id +
                ", streat='" + street + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
