package homework15_12.models;

public interface Employee {
    public int getMonthSalary();
    public void onFire();
    public void onHire(int id, int salaryIn, String nameIn);

    public void returnEmployee();
}
