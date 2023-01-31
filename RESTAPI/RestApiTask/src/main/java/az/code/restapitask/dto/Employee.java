package az.code.restapitask.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Employee {
    private long id ;
    private String name;
    private String surname ;
    private List<Task> tasks;

}
