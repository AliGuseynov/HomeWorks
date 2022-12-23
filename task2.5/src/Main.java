public class Main {
    public static void main(String[] args) {
        Company c = new Company();
        for (int m = 1; m < 10; m++) {
            Manager newM = new Manager(100 * m, m);
            c.employees.add(newM);
        }
        for (int m = 10; m < 20; m++) {
            TopManager newM = new TopManager(100 * m, m);
            c.employees.add(newM);
        }
        for (int m = 20; m < 30; m++) {
            Operator newM = new Operator(100 * m, m);
            c.employees.add(newM);
        }
        c.hire();
        c.hireAll();
        c.fire(12);
        c.getTopSalaryStaff(3);
        c.getLowestSalaryStaff(4);
    }
}
