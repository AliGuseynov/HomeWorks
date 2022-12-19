package bean;

import inter.EmployeeInter;

public class Operator extends Employee {

    public Operator(int i, String name, String surname, int age, double salary,EmployeeType employeeType) {
        this.setId(i);
        this.setAge(age);
        this.setName(name);
        this.setSurname(surname);
        this.setSalary(salary);
        this.setEmployeeType(employeeType);
    }
}
