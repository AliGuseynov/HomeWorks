package company.employee;

import company.CompanyConfig;

public class Manager implements Employee {

    private String workName;
    private String name;

    private String surname;
    private int salary;

    private int staj;

    public Manager() {
    }

    public Manager(String workName, String name, String surname, int salary, int staj) {
        this.workName = workName;
        this.name = name;
        this.surname = surname;
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
        return staj * 100 + 1000;
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
//        TODO Bunun ichin doldur
    }

    @Override
    public void onHire() {
        System.out.println( CompanyConfig.hire(getWorkName()));
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
