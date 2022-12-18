package homeworks.homework6.company.repo;

import homeworks.homework6.company.model.Employee;
import homeworks.homework6.company.model.Manager;
import homeworks.homework6.company.model.Operator;
import homeworks.homework6.company.model.TopManager;

import java.util.ArrayList;
import java.util.List;

public class CompanyImpl implements ICompany {

    List<Employee> employeeList = new ArrayList<>();

    @Override
    public void hire(String role, String name, int salary) {

        int id = 1;
        switch (role) {
            case "manager":
                Employee managerEmploye = new Manager();
                managerEmploye.onHire(id++, name);
                break;
            case "operator":
                Employee operatorEmployee = new Operator();
                operatorEmployee.onHire(id++, name);
                break;
            case "topManager":
                Employee topManagerEmployee = new TopManager();
                topManagerEmployee.onHire(id++, name);
                break;
        }

    }

    @Override
    public void hireAll() {


    }

    @Override
    public void fire(int count) {
        for (int i = 0; i < count; i++) {

            employeeList.remove(i);//??
        }
    }

    @Override
    public void getAllEmployees() {

    }


    @Override
    public List<Employee> getTopSalaryStaff(int count) {
        return null;
    }

    @Override
    public List<Employee> getLowestSalaryStaff(int count) {
        return null;
    }

    @Override
    public List<Integer> getEmployeesCount() {
        return null;
    }


//
//    public List<Employee> getEmployeeList() {
//        return employeeList;
//    }
//
//    public void setEmployeeList(List<Employee> employeeList) {
//        this.employeeList = employeeList;
//    }
//
//    void hire(int id, String name) {
//        Operator operator = new Operator();
//        operator.setId(id);
//        operator.setOperatorName(name);
//    }
//
//    void hireAll() {
//    }
//
//    void fire(int count) {
//        for (int i = 0; i <= count; i++) {
//            employeeList.remove(i);
//
//            System.out.println("deleted");
//        }
//    }
//
//    List<Employee> getTopSalaryStaff(int count) {
//        List<Employee> newTopSalary = new ArrayList<>();
//        for(int i=0;i<=count;i++){
////            newTopSalary.add()
//        }
//        return null;
//    }
//
//    List<Employee> getLowestSalaryStaff(int count) {
//        return null;
//    }
}
