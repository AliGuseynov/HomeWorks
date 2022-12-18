package Comparator;

import model.Employee;

import java.util.Comparator;

public class EmployeeSalaryAscendingComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {

        // in ascending order
        return o1.getMonthSalary() - o2.getMonthSalary();
    }
}
