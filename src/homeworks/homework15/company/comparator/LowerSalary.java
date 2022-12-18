package homeworks.homework15.company.comparator;

import homeworks.homework15.company.model.Employee;

import java.util.Comparator;

public class LowerSalary implements Comparator<Employee> {


    @Override
    public int compare(Employee o1, Employee o2) {
        return (int) (o1.getMonthSalary() - o2.getMonthSalary());
    }
}
