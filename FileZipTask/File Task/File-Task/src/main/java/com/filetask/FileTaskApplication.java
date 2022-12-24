package com.filetask;


import com.filetask.student.Address;
import com.filetask.student.Student;
import com.filetask.student.Subject;
import org.json.JSONObject;
import org.json.XML;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.List;

public class FileTaskApplication {

	public static void main(String[] args) {
		Student student = new Student(1,"Name",
				new Address(1,"Street","City", LocalDate.now()),LocalDate.now(),
				List.of(
						new Subject(1,"Computer Science"),
						new Subject(1,"Economy")
				));

//		objectToXml(student);
		try {
			xmlToJSON();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static void xmlToJSON() throws IOException {
		File xmlFile = new File("student.xml");

		byte[] byteArray = Files.readAllBytes(xmlFile.toPath());

		String xmlStr = new String(byteArray);

		JSONObject jsonObject = XML.toJSONObject(xmlStr);

		System.out.println(jsonObject);
	}

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

}
