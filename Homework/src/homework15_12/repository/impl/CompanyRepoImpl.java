package homework15_12.repository.impl;

import homework15_12.models.*;
import homework15_12.repository.companyRepo;

import java.util.*;

public class CompanyRepoImpl implements companyRepo {
    List<Employee> employeesList = new ArrayList<>();
    int employeeId = 0;

    @Override
    public void hire(int scenario, String name, Integer salary) {


        switch (scenario){
            case 1:
                Employee newEmployee = new Operator();
                newEmployee.onHire(++employeeId, salary, "Operator name "+ name);
                employeesList.add(newEmployee);
                break;
            case 2:
                newEmployee = new Manager();
                newEmployee.onHire(++employeeId, salary, "Manager name "+ name);
                employeesList.add(newEmployee);
                break;
            case 3:
                newEmployee = new Manager();
                newEmployee.onHire(++employeeId, salary, "Top manager name "+ name);
                employeesList.add(newEmployee);
                break;
        }

    }

    @Override
    public void hireAll() {

    }

    @Override
    public void fire(int count) {

        for (int i = 0; i<count; i++){
            Integer rnadomId = (int)(Math.random()*employeesList.size());
            employeesList.get(rnadomId).onFire();
            employeesList.remove(rnadomId);
        }

    }

    @Override
    public List<Employee> getTopSalaryStaff(int count) {

        List<Employee> listOut = employeesList;
        Collections.sort(listOut, new PersonComparator());

        if (count>listOut.size()){
            count = listOut.size();
        }

        for (int i = 0; i<count; i++){
            listOut.get(i).returnEmployee();
        }

        return listOut;
        //employeesList.sort(Comparator.comparing(employeesList::getMonthSalary));

    }

    @Override
    public List<Employee> getLowestSalaryStaff(int count) {


        List<Employee> listOut = employeesList;
        Collections.sort(listOut, new PersonComparator().reversed());

        if (count>listOut.size()){
            count = listOut.size();
        }

        for (int i = 0; i<count; i++){
            listOut.get(i).returnEmployee();
        }

        return listOut;
    }

    @Override
    public List<Integer> getEmployeesCount() {
        List<Integer> employeesByCategory = Arrays.asList(0,0,0);
        for (Employee employee: employeesList){
            if (employee.getClass() == Operator.class){
                employeesByCategory.set(0, employeesByCategory.get(0)+1);
            }
            if (employee.getClass() == Manager.class){
                employeesByCategory.set(1, employeesByCategory.get(1)+1);
            }
            if (employee.getClass() == TopManager.class){
                employeesByCategory.set(2, employeesByCategory.get(2)+1);
            }
        }
        return employeesByCategory;
    }

    @Override
    public void returnAllEmployees() {
        for (Employee employee: employeesList){
            employee.returnEmployee();
        }
    }


}
