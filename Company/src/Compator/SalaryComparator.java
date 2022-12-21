package Compator;

import Model.Employee;

import java.util.Comparator;

public class SalaryComparator implements Comparator<Employee> {
    public int compare(Employee o1, Employee o2) {
        return Integer.compare(o1.getMonthSalary(), o2.getMonthSalary());
    }
}