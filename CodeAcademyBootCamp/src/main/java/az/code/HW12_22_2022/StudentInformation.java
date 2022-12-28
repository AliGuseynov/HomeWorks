package az.code.HW12_22_2022;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class StudentInformation {
    String birthday;
    private String fatherName;

//    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public StudentInformation(String birthday, String fatherName) {
        this.birthday = birthday;
        this.fatherName = fatherName;
    }

    public StudentInformation() {

    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {

        LocalDate localDate= LocalDate.parse(birthday);
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    @Override
    public String toString() {
        return "HW12_22_2022.StudentInformation{" +
                "birthday=" + birthday +
                ", fatherName='" + fatherName + '\'' +
                '}';
    }
}
