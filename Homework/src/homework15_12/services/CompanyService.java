package homework15_12.services;

import homework15_12.models.Employee;
import homework15_12.repository.companyRepo;
import homework15_12.repository.impl.CompanyRepoImpl;

import java.util.List;

public class CompanyService {

    companyRepo company = new CompanyRepoImpl();

    public void hire(int scenario, String name, Integer salary){
        company.hire(scenario, name, salary);
    }
    public void hireAll(){
        List<Integer> employeesList = company.getEmployeesCount();

        Integer countToGenerate = 0;

        for (int i = 0; i<employeesList.size();i++){
            if (i == 0){

                System.out.println("count " + employeesList.get(i));
                countToGenerate = 200 - employeesList.get(i);

                for (int j = 0; j<countToGenerate; j++){
                    hire(1,"generic name " + j, (int)(Math.random()*j*100+5));
                }}
            if (i == 1){
                countToGenerate = 50 - employeesList.get(i);
                    for (int j = 0; j<countToGenerate; j++){
                        hire(2,"generic name " + j, (int)(Math.random()*j*350));
                    }}
            if (i == 2){
                countToGenerate = 10 - employeesList.get(i);
                for (int j = 0; j<countToGenerate; j++){
                    hire(3,"generic name " + j, (int)(Math.random()*j*550));
                }}
            }}
    public void fire(int count) {
        company.fire(count);
    }
    public void getTopSalaryStaff(int count) {
        company.getTopSalaryStaff(count);
    }
    public void getLowestSalaryStaff(int count){
        company.getLowestSalaryStaff(count);
    }

    public void returnAllEmployees(){
        company.returnAllEmployees();
    }
}
