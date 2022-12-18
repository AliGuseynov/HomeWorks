package homeworks.homework15.company.business;

import homeworks.homework15.company.comparator.LowerSalary;
import homeworks.homework15.company.comparator.TopSalary;
import homeworks.homework15.company.model.Employee;
import homeworks.homework15.company.model.Manager;
import homeworks.homework15.company.model.Operator;
import homeworks.homework15.company.model.TopManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CompanyRepompl implements ICompanyRepo {

    List<Employee> employeeList = new ArrayList<>();

    @Override
    public void hire(String name, String role) {
        Employee newEmployeeList = null;
        int id = 1;
        switch (role.toLowerCase()) {
            case "operator":
                newEmployeeList = new Operator(id++, name);

                break;
            case "manager":
                newEmployeeList = new Manager(id++, name);
                break;
            case "topManager":
                newEmployeeList = new TopManager(id++, name);

                break;
        }
        System.out.println(employeeList.add(newEmployeeList));

    }

    @Override
    public void hireAll(List<Employee> newEmployees) {


    }

    @Override
    public void fire(int count) {
        for (int i = 0; i < count; i++) {
            employeeList.remove(i);
        }
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    @Override
    public List<Employee> getTopSalaryStaff(int count) {

        List<Employee> employees = new ArrayList<>();
        Collections.sort(employeeList, new TopSalary());

        for (int i = 0; i < count; i++) {
            employees.add(employeeList.get(i));
        }

        return employees;
    }

    @Override
    public List<Employee> getLowestSalaryStaff(int count) {
        List<Employee> employees = new ArrayList<>();
        Collections.sort(employeeList, new LowerSalary());

        for (int i = 0; i < count; i++) {
            employees.add(employeeList.get(i));
        }

        return employees;
    }

    @Override
    public List<Integer> getEmployeesCount() {
        return null;
    }
}
