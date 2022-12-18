package homeworks.homework6.company.model;

import homeworks.homework6.company.helper.Helper;
import homeworks.homework6.company.repo.CompanyImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CompanyImpl company = new CompanyImpl();
        List<Employee> employeeList = new ArrayList<>();

        for (int i = 1; i <= 200; i++) {
            employeeList.add(new Operator(0 + i, "operator-" + i, Helper.getRandomInteger(1, 100)));
        }
        for (int i = 1; i <= 50; i++) {
            employeeList.add(new Manager(0 + i, "manager-" + i, Helper.getRandomInteger(1, 200)));

        }
        for (int i = 0; i <= 10; i++) {
            employeeList.add(new TopManager(0 + i, "topManager-" + i, Helper.getRandomInteger(1, 300)));
        }


        System.out.println(employeeList);


    }
}
