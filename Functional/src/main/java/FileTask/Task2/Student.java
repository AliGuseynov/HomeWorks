package FileTask.Task2;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import java.time.LocalDate;
import java.time.LocalDateTime;


@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class Student {
    private int id;
    private String name;
    private Adress address;
    private LocalDate creationDate;
    public Student() {
    }

    public Student(int id, String name, Adress address, LocalDate creationDate) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.creationDate = creationDate;
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
    public Adress getAddress() {
        return address;
    }
    public void setAddress(Adress address) {
        this.address = address;
    }
    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", creationDate=" + creationDate +
                '}';
    }
}
