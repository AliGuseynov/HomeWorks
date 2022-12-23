public class Operator implements Employee{
    int salary;
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Operator() {
    }

    public Operator(int salary, int id) {
        this.salary = salary;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Operator{" +
                "salary=" + salary +
                ", id=" + id +
                '}';
    }

    @Override
    public int getMonthSalary() {
        return this.getSalary();
    }

    @Override
    public void onFire() {
        System.out.println("operator isden cixarildi");

    }
    @Override
    public int compareTo(Employee o) {
        return o.getMonthSalary()-this.getSalary();
    }

    @Override
    public void onHire() {
        System.out.println("yeni operator daxil olundu");

    }
}
