package impl;

import bean.Company;
import bean.Employee;
import inter.CompanyInter;

import java.util.ArrayList;
import java.util.List;

public class CompanyImpl implements CompanyInter {
    public static List<Company> companies = new ArrayList<>();
    public static   List<Employee> employeeFireList=new ArrayList<>();
    List<Employee> employeeMaxSalary = new ArrayList<>();
    List<Employee> employeeMinSalary = new ArrayList<>();
    List<Employee> listEmployees=new ArrayList<>();


    @Override
    public void hire(Employee employee,int id) {
        for (Company company:companies
             ) {
            if(company.getId()==id){
                listEmployees.add(employee);
                company.setEmployeeList(listEmployees);
            }
        }
    }

    @Override
    public List<Employee> hireAll(List<Employee>employees,int id) {
        for (Company company:companies
        ) {
            if(company.getId()==id){
                company.setEmployeeList(employees);
            }
        }
        return employees;
    }

    @Override
    public void fire(int count,int id) {
        for (int i=0;i<companies.size();i++) {
            if(companies.get(i).getId()==id){
                for(int j=0;j<count;j++){
                    employeeFireList.add(companies.get(i).getEmployeeList().get(j));
                }
                companies.get(i).getEmployeeList().removeAll(employeeFireList);
            }
        }

    }

    @Override
    public List<Employee> getTopSalaryStaff(double count) {
        for (int i=0;i<companies.size();i++) {
                for(int j=0;j<companies.get(i).getEmployeeList().size();j++) {
                    if(companies.get(i).getEmployeeList().get(j).getSalary()>count){
                        employeeMaxSalary.add(companies.get(i).getEmployeeList().get(j));
                    }
                }
        }
        return employeeMaxSalary;
    }


    @Override
    public List<Employee> getLowestSalaryStaff(double count) {
        for (int i=0;i<companies.size();i++) {
            for(int j=0;j<companies.get(i).getEmployeeList().size();j++) {
                if(companies.get(i).getEmployeeList().get(j).getSalary()<count){
                    employeeMinSalary.add(companies.get(i).getEmployeeList().get(j));
                }
            }
        }
        return employeeMinSalary;
    }

}
