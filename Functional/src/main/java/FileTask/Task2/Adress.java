package FileTask.Task2;

import java.time.LocalDateTime;

public class Adress {
    private int id;
    private String street;
    private String city;
    private LocalDateTime creationTime;

    public Adress() {
    }

    public Adress(int id, String streat, String city,LocalDateTime time) {
        this.id = id;
        this.street = streat;
        this.city = city;
        this.creationTime=time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    @Override
    public String toString() {
        return "Adress{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", time= "+creationTime+
                '}';
    }
}
