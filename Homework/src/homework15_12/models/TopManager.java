package homework15_12.models;

public class TopManager extends Person implements Employee{
    public TopManager() {
        super();
    }

    @Override
    public int getMonthSalary() {
        return salary;
    }

    @Override
    public void onFire() {

        System.out.println(name + " Fired!");
    }

    @Override
    public void onHire(int id,int salaryIn, String nameIn) {

        this.id = id;
        this.salary = salaryIn;
        this.name = nameIn;
        System.out.println(name + " Hired!");
    }
}
