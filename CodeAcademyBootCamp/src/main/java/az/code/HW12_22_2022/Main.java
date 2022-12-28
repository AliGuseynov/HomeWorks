package az.code.HW12_22_2022;

import org.json.JSONObject;
import org.json.XML;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Student student = new Student(1, "leyla", "khalilli");
        Address address = new Address("Azerbaycan", "Baki");
        StudentInformation studentInformation = new StudentInformation("2001-08-26", "Yadigar");

        student.setAddress(address);
        student.setStudentInformation(studentInformation);
        //pojo to xml
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);

            Marshaller marshaller = jaxbContext.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

//            File file = new File("student.xml"); C:\FileConvert

            marshaller.marshal(student, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

//xml to pojo
//        toObject();


        //object to json
//        System.out.println(new Gson().toJson(student));


//        xml to json

        xmlToJson();
    }


    public static void toObject() {

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);

            File file = new File("C:\\FileConvert\\student.xml");
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Student student = (Student) unmarshaller.unmarshal(file);
            System.out.println(student + " " + student.getFirstName() + "" + student.getLastName());

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }


    public static void xmlToJson() throws IOException {
        String line = "", str = "";

        String link = "C:\\FileConvert\\student.xml";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(link));
        while ((line = bufferedReader.readLine()) != null) {
            str += line;
        }

        JSONObject jsonObject = XML.toJSONObject(str);
        System.out.println(jsonObject);
    }

}
