package Model;

import Repository.Repo;

import java.util.List;

public class TopManager implements Employee{

    private String name;
    private int income;

    public TopManager() {
    }

    public TopManager(String name, int income) {
        this.name = name;
        this.income = income;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }
    @Override
    public int getMonthSalary() {
        return this.income;
    }

    @Override
    public void onFire() {
        Company company=new Company();
        List<Employee> emp=company.fire(Repo.employeeList.size()/2);
        for (Employee e:emp){
            if (e.toString().contains("Top_Manager") && !e.toString().contains("Model.Manager")){
                System.out.println(e);
            }
        }
    }
    @Override
    public void onHire() {
        Company company=new Company();
        List<Employee> emp=company.hireAll();
        for (Employee e:emp){
            if (e.toString().contains("top manager") && !e.toString().contains("manager")){
                System.out.println(e);
            }
        }
    }
    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", income=" + income
                ;
    }
}
