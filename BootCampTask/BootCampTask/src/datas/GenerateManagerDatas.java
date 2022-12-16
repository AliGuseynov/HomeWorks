package datas;

import company.employee.Employee;
import company.employee.Manager;
import company.employee.TopManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenerateManagerDatas {

    public static List<Employee> managerListGenerator(int count) {
        List<Employee> result = new ArrayList<>();
        Manager Manager = new Manager();
        for (int i = 0; i < count; i++) {
            Random random = new Random();
            String workName = "Manager";
            String name = Datas.getNames()[random.nextInt(Datas.getNames().length)];
            String surname = Datas.getSurnames()[random.nextInt(Datas.getSurnames().length)];
            int salary = Manager.getSalary();
            int staj = random.nextInt(50);
            Manager employee = new Manager(workName, name, surname, salary, staj);
            result.add(employee);
        }
        return result;
    }

    public static Manager managerGenerator() {
        Manager manager = new Manager();
        Random random = new Random();
        String workName = "Top Manager";
        String name = Datas.getNames()[random.nextInt(Datas.getNames().length)];
        String surname = Datas.getSurnames()[random.nextInt(Datas.getSurnames().length)];
        int salary = manager.getSalary();
        int staj = random.nextInt(50);
        TopManager employee = new TopManager(workName, name, surname, salary, staj);
        return employee;
    }

}
