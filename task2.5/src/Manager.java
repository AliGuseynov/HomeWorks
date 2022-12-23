public class Manager implements Employee{
   int salary;
   int id;

    public Manager() {
    }

    public Manager(int salary, int id) {
        this.salary = salary;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "salary=" + salary +
                ", id=" + id +
                '}';
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getMonthSalary() {
        return this.getSalary();
    }

    @Override
    public void onFire() {
        System.out.println("manager isden cixarildi");

    }

    @Override
    public void onHire() {
        System.out.println("yeni manager daxil olundu");
    }

    @Override
    public int compareTo(Employee o) {
        return o.getMonthSalary()-this.getSalary();
    }
}
