package az.code.restapi.services;

import az.code.restapi.models.Employee;
import az.code.restapi.models.Task;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Seeder {


    public static List<Task> fillTasks(){
        List<Task> tasks = new ArrayList<>();

        tasks.add(Task.builder().id(1l).title("task1").description("Lorem ipsum").dueDate(LocalDate.now()).build());
        tasks.add(Task.builder().id(2l).title("task2").description("Lorem ipsum").dueDate(LocalDate.now()).build());
        tasks.add(Task.builder().id(3l).title("task3").description("Lorem ipsum").dueDate(LocalDate.now()).build());
        tasks.add(Task.builder().id(4l).title("task4").description("Lorem ipsum").dueDate(LocalDate.now()).build());

        return tasks;
    }

    public static List<Employee> getEmployees(){


        List<Task> tasks = fillTasks();

        List<Employee> employeeList = new ArrayList<>();
         employeeList.add(Employee.builder().id(0l).name("Elnur").surname("Aliyev").taskList(tasks).build());
        employeeList.add( Employee.builder().id(2l).name("Jamal").surname("khalilov").taskList(tasks).build());
        employeeList.add( Employee.builder().id(3l).name("Jamal").surname("Khalilov").taskList(tasks).build());
        employeeList.add( Employee.builder().id(4l).name("Jamal").surname("Veliyev").taskList(tasks).build());
        employeeList.add( Employee.builder().id(5l).name("Ruslan").surname("Mammadov").taskList(tasks).build());
        employeeList.add( Employee.builder().id(6l).name("Jamal").surname("Zeynalov").taskList(tasks).build());
        employeeList.add( Employee.builder().id(7l).name("Jamal").surname("Abbasov").taskList(tasks).build());

        return employeeList;
    }
}
