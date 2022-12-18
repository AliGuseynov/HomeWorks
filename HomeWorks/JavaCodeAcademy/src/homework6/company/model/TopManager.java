package homework6.company.model;

import java.util.ArrayList;
import java.util.List;

public class TopManager implements Employee {
    private int id;
    private String topManagerName;
    private double tSalary;

    public TopManager(int id, String topManagerName, double tSalary) {
        this.id = id;
        this.topManagerName = topManagerName;
        this.tSalary = tSalary;
    }

    public TopManager() {
    }

    @Override
    public double getMonthSalary(double tSalary) {

        return (tSalary * 30);
    }

    @Override
    public void onFire(Employee employee) {
        List<Employee> topManagerFire = new ArrayList<>();
        topManagerFire.add(employee);

    }

    @Override
    public void onHire(int id, String name) {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTopManagerName() {
        return topManagerName;
    }

    public void setTopManagerName(String topManagerName) {
        this.topManagerName = topManagerName;
    }

    public double gettSalary() {
        return tSalary;
    }

    public void settSalary(double tSalary) {
        this.tSalary = tSalary;
    }

    @Override
    public String toString() {
        return "\nTopManager" + " " + "id=" + id + " " +
                "topManagerName=" + topManagerName + " " +
                "topManagerSalary=" + tSalary + " " +
                "///////////";
    }


}
