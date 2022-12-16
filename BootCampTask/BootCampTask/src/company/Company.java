package company;

import company.employee.Employee;

import java.util.List;

public class Company {
    public String companyName;
    public List<List<Employee>> employeeList;

    public Company() {
    }

    public Company(String companyName, List<List<Employee>> employeeList) {
        this.companyName = companyName;
        this.employeeList = employeeList;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<List<Employee>> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<List<Employee>> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyName='" + companyName + '\'' +
                ", employeeList=" + employeeList +
                '}';
    }
}
