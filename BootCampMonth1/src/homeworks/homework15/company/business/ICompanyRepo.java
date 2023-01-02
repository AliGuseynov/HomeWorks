package homeworks.homework15.company.business;

import homeworks.homework15.company.model.Employee;

import java.util.List;

public interface ICompanyRepo {
    void hire(String name, String role);

    void hireAll(List<Employee> newEmployees);

    void fire(int count);

    List<Employee> getAllEmployees();

    List<Employee> getTopSalaryStaff(int count);

    List<Employee> getLowestSalaryStaff(int count);

    public List<Integer> getEmployeesCount();

}
