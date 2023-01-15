package Model;

import Repository.Repo;

import java.util.List;

public class Manager implements Employee{

    private String name;
    private int income;


    public Manager() {
    }

    public Manager(String name, int income) {
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
            if (e.toString().contains("Manager") && !e.toString().contains("Top_Manager")){
                System.out.println(e);
            }
        }
    }

    @Override
    public void onHire() {
        Company company=new Company();
        List<Employee> emp=company.hireAll();
        for (Employee e:emp){
            if (e.toString().contains("manager") && !e.toString().contains("top manager")){
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