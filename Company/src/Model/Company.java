package Model;

import Compator.SalaryComparator;
import Model.Employee;
import Model.Manager;
import Model.Operator;
import Model.TopManager;
import Repository.Repo;

import java.util.*;

public class Company {
    List<Employee> employees=Repo.employeeList;

    public List<Employee> hire(){
        Scanner c=new Scanner(System.in);
        String name=c.nextLine();
        int income=c.nextInt();
        Employee employee=new Manager(name,income);
        employees.add(employee);
        return employees;
    }
    public List<Employee> hireAll(){//elave olunanlari versin
        List<Employee> hired=new ArrayList<>();
        Employee manager_employee=new Manager("new manager employee",750);
        Employee top_manager_employee=new TopManager("new top manager employee",800);
        Employee operator_employee=new Operator("new operator employee",900);
        hired.add(manager_employee);
        hired.add(top_manager_employee);
        hired.add(operator_employee);
        return hired;
    }

    public List<Employee> fire(int count){
        List<Employee> removed=new ArrayList<>();
        for (int i=0;i<=count;i++){
            Random r=new Random();
            int rando = r.nextInt(employees.size());
            System.out.println(rando);
            Employee text = employees.get(rando);
            System.out.println(text);
            System.out.println("-------------------------");
            employees.remove(text);
            removed.add(text);
        }
        return removed;
    }

    public List<Employee> getTopSalaryStaff(int count){
        List<Employee> employeeList=Repo.employeeList;
        employeeList.sort(new SalaryComparator());
        Collections.sort(employeeList,new SalaryComparator());
        List<Employee> topCount= employeeList.subList(employeeList.size()-count, employeeList.size());
        return topCount;
    }
    public List<Employee> getLowSalaryStaff(int count){//5
        List<Employee> employeeList= Repo.employeeList;
        employeeList.sort(new SalaryComparator());
        Collections.sort(employeeList,new SalaryComparator());//10
        List<Employee> topCount= employeeList.subList(0,count);
        return topCount;
    }




}
