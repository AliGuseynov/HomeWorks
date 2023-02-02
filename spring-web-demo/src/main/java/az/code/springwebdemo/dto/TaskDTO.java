package az.code.springwebdemo.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@Builder(toBuilder = true)
public class TaskDTO {
    long task_id;
    String title;
    String description;
    Date dueDate;

    @Override
    public String toString() {
        return "TaskDTO{" +
                "id=" + task_id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", dueDate=" + dueDate +
                '}';
    }

}
