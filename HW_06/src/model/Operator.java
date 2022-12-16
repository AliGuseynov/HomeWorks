package model;

public class Operator implements Employee {


    private String name;
    private int salary;

    public Operator(String name) {
        this.name = name;
        this.salary = (int) (Math.random() * 1000);
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
