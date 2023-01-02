package homeworks.homework15.company.model;

public class TopManager implements homeworks.homework15.company.model.Employee {
    private int id;
    private String topManagerName;
    private double tSalary;

    public TopManager(int id, String topManagerName) {
        this.id = id;
        this.topManagerName = topManagerName;
        this.tSalary = (int) (Math.random() * 1000);

    }

    public TopManager() {
    }

    @Override
    public double getMonthSalary() {

        return (tSalary * 30);
    }

    @Override
    public void onFire() {
        System.out.println("Ishden cixarildi-" + topManagerName);


    }

    @Override
    public void onHire() {
        System.out.println("işə qəbul edildi-" + topManagerName);

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
        this.tSalary = (int) (Math.random() * 1000);

    }

    @Override
    public String toString() {
        return "\nTopManager" + " " + "id=" + id + " " +
                "topManagerName=" + topManagerName + " " +
                "topManagerSalary=" + tSalary + " " +
                "///////////";
    }


}
