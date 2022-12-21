import Model.Company;
import Model.Employee;
import Repository.Repo;

import java.util.List;
public class Main {
    public static void main(String[] args) {
        Company company=new Company();
        List<Employee> listAll= Repo.employeeList;
        for (Employee e:listAll){
            System.out.println(e);
        }
        System.out.println("Numbers of employees : "+listAll.size());
        System.out.println("+++++++++++++++++++++++++");
        company.fire(Repo.employeeList.size()/2);
        for (Employee e:listAll){
            System.out.println(e);
        }
        System.out.println("Numbers of employee after fired : "+listAll.size());
        System.out.println("-----------------------");
        List<Employee> top=company.getTopSalaryStaff(5);
        System.out.println("Max income: "+top);
        List<Employee> min=company.getLowSalaryStaff(4);
        System.out.println("Min income"+min);
//        System.out.println(listAll);
//        Model.Company company=new Model.Company();
//        List<Model.Employee> list=company.getTopSalaryStaff(1);
//        System.out.println(company.hire());
//        for (Model.Employee e:list){
//            System.out.println(e);
//        }
//        System.out.println("-------------------");
//
//        List<Model.Employee> removed=company.fire(Repository.Repo.employeeList.size()/2);
//        for (Model.Employee e:removed){
//            System.out.println(e);
//        }
        Model.Manager m=new Model.Manager();
        m.onHire();
        for (Model.Employee e:listAll){
            System.out.println(e);
        }

//        List<Model.Employee> list=Repository.Repo.employeeList;
//        for (Model.Employee e:list){
//            System.out.println(e);
//        }


//        company.hireAll();

//        Model.Manager manager=new Model.Manager();
//
//        System.out.println(manager.getMonthSalary());

    }

    }
