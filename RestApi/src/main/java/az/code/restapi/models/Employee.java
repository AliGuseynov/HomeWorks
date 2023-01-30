package az.code.restapi.models;

import lombok.*;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder(toBuilder = true)
public class Employee {

    private Long id;
    private String name;
    private String surname;
    private List<Task> taskList;
}
