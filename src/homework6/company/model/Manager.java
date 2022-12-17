package homework6.company.model;

import java.util.ArrayList;
import java.util.List;

public class Manager implements Employee {
    private int id;
    private String managerName;
    private double mSalary;

    public Manager(int id, String managerName, double mSalary) {
        this.id = id;
        this.managerName = managerName;
        this.mSalary = mSalary;
    }

    public Manager() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public double getmSalary() {
        return mSalary;
    }

    public void setmSalary(double mSalary) {
        this.mSalary = mSalary;
    }

    @Override
    public double getMonthSalary(double mSalary) {

        return (mSalary * 30);
    }

    @Override
    public void onFire(Employee employee) {
//        List<Employee> managerFire = new ArrayList<>();
//        managerFire.add(employee);
    }

    @Override
    public void onHire(int id, String name) {

    }


    @Override
    public String toString() {
        return "\nManager:" + ' ' +
                "id=" + id + ' ' +
                "managerName=" + managerName +
                "managerSalary=" + mSalary +
                "----------------------------";
    }
}
