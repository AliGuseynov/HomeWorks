package homeworks.homework15.company.model;

public class Operator implements homeworks.homework15.company.model.Employee {

    private int id;
    private String operatorName;
    private double oSalary;


    public Operator(int id, String operatorName) {
        this.id = id;
        this.operatorName = operatorName;
        this.oSalary = (int) (Math.random() * 100);
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
        this.oSalary = (int) (Math.random() * 1000);
    }

    @Override
    public double getMonthSalary() {
        return (oSalary * 30);
    }

    @Override
    public void onFire() {
        System.out.println("Ishden cixarildi-" + operatorName);

    }

    @Override
    public void onHire() {
        System.out.println("işə qəbul edildi-" + operatorName);

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
