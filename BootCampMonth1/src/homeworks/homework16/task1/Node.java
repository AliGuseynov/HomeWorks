package homeworks.homework16.task1;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Node<T> {
    private T value;
    private LocalDateTime time;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Node(T value, LocalDateTime time) {
        this.value = value;
        this.time = time;
    }


}
