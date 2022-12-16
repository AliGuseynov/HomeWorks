package datas;

import company.employee.Employee;
import company.employee.Manager;
import company.employee.Operator;
import company.employee.TopManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenerateOperatorDatas {

    public static List<Employee> operatorListGenerator(int count) {
        List<Employee> result = new ArrayList<>();
        Operator operator = new Operator();
        for (int i = 0; i < count; i++) {
            Random random = new Random();
            String workName = "Manager";
            String name = Datas.getNames()[random.nextInt(Datas.getNames().length)];
            String surname = Datas.getSurnames()[random.nextInt(Datas.getSurnames().length)];
            int salary = operator.getSalary();
            int staj = random.nextInt(50);
            Operator employee = new Operator(workName, name, surname, salary, staj);
            result.add(employee);
        }
        return result;
    }

    public static Employee operatorGenerator() {
        Operator operator = new Operator();
        Random random = new Random();
        String workName = "Top Manager";
        String name = Datas.getNames()[random.nextInt(Datas.getNames().length)];
        String surname = Datas.getSurnames()[random.nextInt(Datas.getSurnames().length)];
        int salary = operator.getSalary();
        int staj = random.nextInt(50);
        Operator employee = new Operator(workName, name, surname, salary, staj);
        return employee;
    }

}
