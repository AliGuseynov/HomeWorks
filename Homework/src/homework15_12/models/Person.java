package homework15_12.models;

public abstract class Person implements Employee{ // person is parent class for operator manager and top manager

    int id;
    String name;
    int salary;


    @Override
    public int getMonthSalary() {
        return 0;
    }

    @Override
    public void onFire() {

    }

    @Override
    public void onHire(int id, int salaryIn, String nameIn) {

        this.id = id;
        this.name = nameIn;
        this.salary = salaryIn;
    }

    @Override
    public void returnEmployee() {
        System.out.println("Əməkdaş===================" +
                "\nID - " + id + " Ad - " + name + " Salary - " + salary + "\n=====================");
    }

}
