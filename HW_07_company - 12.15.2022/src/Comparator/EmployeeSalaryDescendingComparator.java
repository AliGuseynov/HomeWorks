package Comparator;

import model.Employee;

import java.util.Comparator;

public class EmployeeSalaryDescendingComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {

        // in Descending order
        return o2.getMonthSalary() - o1.getMonthSalary();
    }
}
