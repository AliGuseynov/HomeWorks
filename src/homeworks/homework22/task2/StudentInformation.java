package homeworks.homework22.task2;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StudentInformation {
    String birthday;
    private String fatherName;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

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
        this.birthday = String.valueOf(LocalDateTime.parse(birthday, formatter));
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    @Override
    public String toString() {
        return "StudentInformation{" +
                "birthday=" + birthday +
                ", fatherName='" + fatherName + '\'' +
                '}';
    }
}
