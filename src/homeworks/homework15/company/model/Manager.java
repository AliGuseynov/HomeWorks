package homeworks.homework15.company.model;

public class Manager implements homeworks.homework15.company.model.Employee {
    private int id;
    private String managerName;
    private double mSalary;

    public Manager(int id, String managerName) {
        this.id = id;
        this.managerName = managerName;
        this.mSalary = (int) (Math.random() * 200);

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
        this.mSalary = (int) (Math.random() * 200);

    }

    @Override
    public double getMonthSalary() {

        return (mSalary * 30);
    }

    @Override
    public void onFire() {
        System.out.println("Ishden cixarildi-" + managerName);
    }

    @Override
    public void onHire() {
        System.out.println("işə qəbul edildi-" + managerName);

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
