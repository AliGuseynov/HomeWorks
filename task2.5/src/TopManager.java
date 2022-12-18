public class TopManager implements Employee{
    int salary;
    int id;

    public TopManager() {
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

    public TopManager(int salary, int id) {
        this.salary = salary;
        this.id = id;
    }

    @Override
    public String toString() {
        return "TopManager{" +
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
        System.out.println("topManager isden cixarildi");

    }

    @Override
    public void onHire() {
        System.out.println("yeni topmanager daxil olundu");

    }
    @Override
    public int compareTo(Employee o) {
        return o.getMonthSalary()-this.getSalary();
    }
}
