package com.filetask.task2;

import com.filetask.student.Student;
import org.json.JSONObject;
import org.json.XML;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Converter {

    public static void objectToXml(Student student)
    {
        try
        {
            JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);


            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            File xmlFile = new File("student.xml");
            jaxbMarshaller.marshal(student,xmlFile);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void objectToJSON(Student student){
        //TODO JSON Date goturende error atir mq
    }


    public static void xmlToJSON(File fileName) throws IOException {

        byte[] byteArray = Files.readAllBytes(fileName.toPath());

        String xmlStr = new String(byteArray);

        JSONObject jsonObject = XML.toJSONObject(xmlStr);

        System.out.println(jsonObject);
    }

    public static void jsonToXml(File fileName) throws IOException {
        byte[] byteArray = Files.readAllBytes(fileName.toPath());
        String jsonStr = new String(byteArray);
        JSONObject jsonObject = new JSONObject(jsonStr);

        System.out.println(XML.toString(jsonObject));
    }


}
