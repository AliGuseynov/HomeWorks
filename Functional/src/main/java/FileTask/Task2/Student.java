package FileTask.Task2;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import java.time.LocalDateTime;
import java.util.List;


@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class Student {
    private int id;
    private String name;
    private Adress address;
    private String creationDate;
    List<Subject> subjects;

    public Student() {
    }

    public Student(int id, String name, Adress address, String creationDate,List<Subject> subjects) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.creationDate = creationDate;
        this.subjects=subjects;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
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
    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", creationDate=" + creationDate +
                ", subjects=" + subjects +
                '}';
    }
}
