package FileTask.Task2;
import javax.xml.bind.DatatypeConverter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Task2 {

    public static void main(String[] args) throws JAXBException {
        LocalDateTime dateTime = LocalDateTime.parse("2016-03-23T18:21");
        Adress ad = new Adress(1, "Nizami kucesi", "Baku",dateTime);
        System.out.println(dateTime);
        List<Subject> list=new ArrayList<>();
        Subject s=new Subject(1,"Math");
        list.add(s);
        Student ss = new Student(1, "Nezrin", ad, dateTime.toString(),list);
        try {
            JAXBContext context = JAXBContext.newInstance(Student.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            File file = new File("task2.xml");
            marshaller.marshal(ss, file);
        } catch (JAXBException ex) {
            ex.printStackTrace();
        }
    }

}
