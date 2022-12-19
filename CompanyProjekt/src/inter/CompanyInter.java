package inter;

import bean.Employee;

import java.util.List;

public interface CompanyInter {
    void hire(Employee employee,int id);
    List<Employee> hireAll(List<Employee> employees,int id);
    void fire(int count,int id);
    List<Employee> getTopSalaryStaff(double count);
    List<Employee> getLowestSalaryStaff(double count);

}
