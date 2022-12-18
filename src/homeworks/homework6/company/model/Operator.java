package homeworks.homework6.company.model;

import java.util.ArrayList;
import java.util.List;

public class Operator implements Employee {

    private int id;
    private String operatorName;
    private double oSalary;


    public Operator(int id, String operatorName, double oSalary) {
        this.id = id;
        this.operatorName = operatorName;
        this.oSalary = oSalary;
    }

    public Operator() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public double getoSalary() {
        return oSalary;
    }

    public void setoSalary(double oSalary) {
        this.oSalary = oSalary;
    }

    @Override
    public double getMonthSalary(double oSalary) {
        return (oSalary * 30);
    }

    @Override
    public void onFire(Employee employee) {
        List<Employee> operatorFire = new ArrayList<>();
        operatorFire.add(employee);
    }

    @Override
    public void onHire(int id, String name) {

    }


    @Override
    public String toString() {
        return "\nOperator:" + ' ' +
                "id=" + id + ' ' +
                "operatorName=" + operatorName + " " +
                "operatorSalary=" + oSalary + " " +
                " ////////////////";
    }
}
