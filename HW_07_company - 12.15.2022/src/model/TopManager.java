package model;

public class TopManager implements Employee{
    private String name;
    private int salary;

    public TopManager(String name) {
        this.name = name;
        this.salary = (int) (Math.random() * 5000);
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
