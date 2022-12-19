package impl;

import bean.Company;
import bean.Employee;
import factory.CompanyFactory;
import inter.CompanyInter;
import inter.EmployeeInter;

import java.util.ArrayList;
import java.util.List;

public class EmployeeImpl implements EmployeeInter {
    CompanyInter companyInter=CompanyFactory.createdCompanyInter("memory");
    public static List<Employee> employees = new ArrayList<>();

    @Override
    public List<Employee> onFirePrint() {
        for (Employee employee:CompanyImpl.employeeFireList
             ) {
            System.out.println(employee);
        }
        return CompanyImpl.employeeFireList;
    }



    @Override
    public double getMonthSalary(int id) {
        double sumSalary=0;
        for(Company company:CompanyImpl.companies){
            for(int i=0;i<employees.size();i++){
                sumSalary+=employees.get(i).getSalary();
            }
        }
        return sumSalary;
    }


}
