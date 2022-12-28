package az.code.HW12_23_2022.task1;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

public class Main implements Serializable {
    public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {

        ObjectMapper objectMapper = new ObjectMapper();

        Students student = objectMapper.readValue(new File("C:\\FileConvert\\studentList.json"), Students.class);

        List<Students> studentList = objectMapper.readValue(new File("C:\\FileConvert\\studentList.json"),
                new TypeReference<List<Students>>() {
                });
        System.out.println("student list:" + studentList);

    }
}
