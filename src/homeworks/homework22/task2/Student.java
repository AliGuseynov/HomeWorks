package homeworks.homework22.task2;

import java.util.ArrayList;
import java.util.List;


public class Student {
    private int id;
    private String firstName;
    private String lastName;
    List<Address> addressList = new ArrayList<>();
    List<StudentInformation> studentInformations = new ArrayList<>();

    public Student(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    public List<StudentInformation> getStudentInformations() {
        return studentInformations;
    }

    public void setStudentInformations(List<StudentInformation> studentInformations) {
        this.studentInformations = studentInformations;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", addressList=" + addressList +
                ", studentInformations=" + studentInformations +
                '}';
    }
}
