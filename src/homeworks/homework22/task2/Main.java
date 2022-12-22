package homeworks.homework22.task2;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Student student = new Student(1, "leyla", "khalilli");

        Address address = new Address("Azerbaycan", "Baki");
        StudentInformation studentInformation = new StudentInformation("2001-08-26", "Yadigar");

        student.setAddressList((List<Address>) address);
        student.setStudentInformations((List<StudentInformation>) studentInformation);


//        JAXBContext jaxbContext = JAXBContext.newInstance(User.class);


    }
}
