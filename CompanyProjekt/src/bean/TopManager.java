package bean;

import inter.EmployeeInter;

public class TopManager extends Employee {
    public TopManager(int id, String name, String surname, int age, double salary,EmployeeType employeeType) {
        this.setId(id);
        this.setAge(age);
        this.setName(name);
        this.setSurname(surname);
        this.setSalary(salary);
        this.setEmployeeType(employeeType);
    }
}
