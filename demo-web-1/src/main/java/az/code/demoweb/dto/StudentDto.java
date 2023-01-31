package az.code.demoweb.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class StudentDto {
    Long id;
    String name;
    String surname;
}
