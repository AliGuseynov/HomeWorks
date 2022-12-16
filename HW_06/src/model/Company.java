package model;

import Comparator.*;

import java.time.LocalDate;
import java.util.*;

public class Company {

    private String name;
    private List<Employee> employees = new ArrayList<>();
    private LocalDate dateOfFoundation;

    public Company(String name, LocalDate dateOfFoundation) {
        this.name = name;
        this.dateOfFoundation = dateOfFoundation;
    }

    public void hire(String name, String position) {

        Employee tmpEmployee = null;

        switch (position.toLowerCase()) {
            case "operator":
                tmpEmployee = new Operator(name);
            break;
            case "manager":
                tmpEmployee = new Manager(name);
            break;
            case "topmanager":
                tmpEmployee = new TopManager(name);
            break;
        }

        this.employees.add(tmpEmployee);
    }

    public void hireAll(List<String> newStaff) {

        for (String str : newStaff)
            employees.add(new Operator(str));
    }

    public void fire(int count) {

        while(count > 0) {
            employees.remove(employees.size() - 1);
            count--;
        }
    }

    public List<Employee> getTopSalaryStaff(int count) {

        List<Employee> tmpEmp = new ArrayList<>();

        Collections.sort(employees, new EmployeeSalaryDescendingComparator());

        for (int i = 0; i < count; i++) {
            tmpEmp.add(employees.get(i));
        }

        return tmpEmp;
    }

    public List<Employee> getLowestSalaryStaff(int count) {

        List<Employee> tmpEmp = new ArrayList<>();

        Collections.sort(employees, new EmployeeSalaryAscendingComparator());

        for (int i = 0; i < count; i++) {
            tmpEmp.add(employees.get(i));
        }

        return tmpEmp;
    }

    // Getter and Setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfFoundation() {
        return dateOfFoundation;
    }

    public void setDateOfFoundation(LocalDate dateOfFoundation) {
        this.dateOfFoundation = dateOfFoundation;
    }

    public List<Employee> getEmployees() {

        return employees;
    }

    public LinkedHashMap<Integer, String> getEmployeesDetails() {

        LinkedHashMap<Integer, String> employeeDetails = new LinkedHashMap<>();

        for (Employee e : employees)
            employeeDetails.put(e.getMonthSalary(), e.getName());

        return employeeDetails;
    }
}
