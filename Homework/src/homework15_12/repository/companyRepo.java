package homework15_12.repository;

import homework15_12.models.Employee;

import java.util.List;

public interface companyRepo {
    public void hire(int scenario, String name, Integer salary);
    public void hireAll();
    public void fire(int count);
    public List<Employee> getTopSalaryStaff(int count);

    public List<Employee> getLowestSalaryStaff(int count);

    public List<Integer> getEmployeesCount();

    public void returnAllEmployees();


}
