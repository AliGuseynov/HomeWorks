package service;

import bean.*;
import factory.CompanyFactory;
import inter.CompanyInter;

import java.util.List;

public class CompanyService {
    CompanyInter companyInter= CompanyFactory.createdCompanyInter("memory");
    public  void hireAddByUser(int companyId,int id, String name, String surname, int age, double salary, EmployeeType employeeType){

        if(EmployeeType.Manager==employeeType){
            companyInter.hire(new Manager(id,name,surname,age,salary,employeeType), companyId);
        }else if(EmployeeType.TopManager==employeeType){
            companyInter.hire(new TopManager(id,name,surname,age,salary,employeeType), companyId);
        }else if(EmployeeType.Operator==employeeType){
            companyInter.hire(new Operator(id,name,surname,age,salary,employeeType), companyId);
        }else{
            System.out.println("bele bir tip yoxdur");
        }

    }
    public  void hireAllByUser(List<Employee> list,int id){
        companyInter.hireAll(list,id);
    }
    public void fireByUser(int count,int id){
        companyInter.fire(count,id);
    }
    public void maxSalaryList(double count){
        for (Employee employee:companyInter.getTopSalaryStaff(count)
             ) {
            System.out.println(employee);
        }

    }
    public void minSalary(double count){
        for (Employee employee:companyInter.getLowestSalaryStaff(count)
             ) {
            System.out.println(employee);
        }
    }
}
