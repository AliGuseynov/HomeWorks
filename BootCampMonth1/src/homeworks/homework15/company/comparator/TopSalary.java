package homeworks.homework15.company.comparator;

import homeworks.homework15.company.model.Employee;

import java.util.Comparator;

public class TopSalary implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return (int) (o2.getMonthSalary() - o1.getMonthSalary());
    }
}
