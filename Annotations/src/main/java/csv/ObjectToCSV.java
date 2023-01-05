package csv;

import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class ObjectToCSV {

    public static void main(String args[]) throws Exception {
        String CSV_LOCATION = "output.csv ";
        FileWriter writer = new FileWriter(CSV_LOCATION);
        Student s=new Student("Nezrin",20,"Suleymanli","11A");
        Student s2=new Student("Serxan",25,"Suleymanli","12B");
        List<Student> list = new ArrayList<>();
        list.add(s);
        list.add(s2);
        ColumnPositionMappingStrategy<Student> mappingStrategy=
                new ColumnPositionMappingStrategy<>();
        mappingStrategy.setType(Student.class);
        String[] columns = new String[]
                { "Name", "Age", "Surname", "ClassName" };
        mappingStrategy.setColumnMapping(columns);
        StatefulBeanToCsvBuilder<Student> builder=
                new StatefulBeanToCsvBuilder<>(writer);
        StatefulBeanToCsv<Student> beanWriter =
                builder.withMappingStrategy(mappingStrategy).build();
        beanWriter.write(list);
        writer.close();
    }
}
