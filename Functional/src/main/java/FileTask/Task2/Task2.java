package FileTask.Task2;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.time.LocalDate;

public class Task2 {

    public static void main(String[] args) throws JAXBException {
        Adress ad = new Adress(1, "Nizami kucesi", "Baku");
        LocalDate d=LocalDate.of(2012,12,15);
        Student s = new Student(1, "Nezrin", ad, d);
        try {
            JAXBContext context = JAXBContext.newInstance(Student.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            File file = new File("salak.xml");
            marshaller.marshal(s, file);

        } catch (JAXBException ex) {
            ex.printStackTrace();
        }
    }

}
