package az.code.HW12_22_2022;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class Student {
    private int id;
    private String firstName;
    private String lastName;
//    List<HW12_22_2022.Address> addressList;
//    List<HW12_22_2022.StudentInformation> studentInformations;

    private Address address;
    private StudentInformation studentInformation;

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public StudentInformation getStudentInformation() {
        return studentInformation;
    }

    public void setStudentInformation(StudentInformation studentInformation) {
        this.studentInformation = studentInformation;
    }


//    public List<HW12_22_2022.Address> getAddressList() {
//        return addressList;
//    }
//
//    public void setAddressList(List<HW12_22_2022.Address> addressList) {
//        this.addressList = addressList;
//    }
//
//    public List<HW12_22_2022.StudentInformation> getStudentInformations() {
//        return studentInformations;
//    }
//
//    public void setStudentInformations(List<HW12_22_2022.StudentInformation> studentInformations) {
//        this.studentInformations = studentInformations;
//    }

    @Override
    public String toString() {
        return "HW12_22_2022.Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", addressList=" + address +
                ", studentInformations=" + studentInformation +
                '}';
    }
}
