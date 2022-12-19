package bean;

import inter.EmployeeInter;

import java.util.List;

public class Company {
    private int id;
    private String name;
    private String address;
    private List<Employee> list;

    public Company() {
    }

    public Company(int id, String name, String address, List<Employee> list) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.list = list;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Employee> getEmployeeList() {
        return list;
    }

    public void setEmployeeList(List<Employee> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", list=" +
                list   +"\n"+
                '}';
    }
}
