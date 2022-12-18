package homeworks.homework6.company.repo;

import homeworks.homework6.company.model.Employee;

import java.util.List;

public interface ICompany {
    public void hire(String role, String name, int salary);

    public void hireAll();

    public void fire(int count);

    public void getAllEmployees();

    public List<Employee> getTopSalaryStaff(int count);

    public List<Employee> getLowestSalaryStaff(int count);

    public List<Integer> getEmployeesCount();

}


