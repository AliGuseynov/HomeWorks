package datas;

import company.employee.Employee;
import company.employee.TopManager;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenerateTopManagerDatas {

    public static List<Employee> topManagerListGenerator(int count) {
        List<Employee> result = new ArrayList<>();
        TopManager topManager = new TopManager();

        for (int i = 0; i < count; i++) {
            Random random = new Random();
            String workName = "Top Manager";
            String name = Datas.getNames()[random.nextInt(Datas.getNames().length)];
            String surname = Datas.getSurnames()[random.nextInt(Datas.getSurnames().length)];

            int salary = topManager.getSalary();
            int staj = random.nextInt(50);

            TopManager employee = new TopManager(workName, name, surname, salary, staj);
            result.add(employee);
        }

        return result;
    }

    public static TopManager topManagerGenerator() {
        TopManager topManager = new TopManager();

        Random random = new Random();
        String workName = "Top Manager";
        String name = Datas.getNames()[random.nextInt(Datas.getNames().length)];
        String surname = Datas.getSurnames()[random.nextInt(Datas.getSurnames().length)];
        int salary = topManager.getSalary();
        int staj = random.nextInt(50);

        TopManager employee = new TopManager(workName, name, surname, salary, staj);
        return topManager;
    }
}
