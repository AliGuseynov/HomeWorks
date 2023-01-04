import lombok.extern.java.Log;
import models.Student;

@Log
public class Main {
    public static void main(String[] args) {

//        int N = 2;
//        HanoiTower.towerOfHanoi(N, 'A', 'C', 'B');


        Student student = Student.builder()
                .age(15)
                .name("Asiman")
                .surname("Suleymanov")
                .build();

        student = student.toBuilder().id(24l).build();
        log.info("STUDENT = " + student);
    }
}