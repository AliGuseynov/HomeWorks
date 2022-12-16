package repository;

import model.Employee;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public interface CompanyRepo {
    void findAllEmployee();
    void hireEmployee(String name, String position);
    void hireEmployees(List<String> newStaff);

    void fireEmployees(int count);

    List<Employee> getAllEmployees();

    LinkedHashMap<Integer, String> getEmployeesDetails();

    List<Employee> getTopSalaryStaff(int count);

    List<Employee> getLowestSalaryStaff(int count);
}
