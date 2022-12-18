package model;

public class Manager implements Employee{

    private String name;
    private int salary;

    public Manager(String name) {
        this.name = name;
        this.salary = (int) (Math.random() * 3000);
    }

    @Override
    public int getMonthSalary() {
        return this.salary;
    }

    @Override
    public void onFire() {

    }

    @Override
    public void onHire() {

    }

    @Override
    public String getName() {
        return name;
    }
}
