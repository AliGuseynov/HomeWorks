package org.example;

import lombok.extern.java.Log;

@Log
public class Main {
    public static void main(String[] args) {
        Student student = Student.builder()
                .age(15)
                .name("Asiman")
                .surname("Suleymanov")
                .build();
        student = student.toBuilder().id(24l).build();
        log.info("STUDENT = " + student);


    }
}