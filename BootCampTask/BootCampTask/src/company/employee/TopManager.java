package company.employee;

import company.CompanyConfig;

public class TopManager extends Manager implements Employee{
    private String workName;
    private String name;

    private String surname;
    private int  salary;

    private int staj;

    public TopManager() {
    }

    public TopManager(String workName, String name,String surname,int salary, int staj) {
        this.workName = workName;
        this.name = name;
        this.salary = salary;
        this.staj = staj;
    }

    public String getWorkName() {
        return workName;
    }

    public void setWorkName(String workName) {
        this.workName = workName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getSalary() {
        return staj*100+2000;
    }

    public int getStaj() {
        return staj;
    }


    @Override
    public int getMonthlySalary() {
        return getSalary();
    }

    @Override
    public void onFire() {

    }

    @Override
    public void onHire() {
        System.out.println(CompanyConfig.hire(workName));
    }

    @Override
    public String toString() {
        return "Work name :" + workName + "\n"
                +"name=" + name + " " + surname + "\n"
                +"salary = " + getMonthlySalary() + "\n"
                +"staj = " + staj +"\n"
                +"-------------------------------------" + "\n";
    }
}
