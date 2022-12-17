package homework6.company.model;

public interface Employee {


    double getMonthSalary(double salary);

    void onFire(Employee employee);

    void onHire(int id,String name);
}
