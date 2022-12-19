import bean.*;
import factory.CompanyFactory;
import impl.CompanyImpl;
import inter.CompanyInter;
import service.CompanyService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        CompanyInter companyInter = CompanyFactory.createdCompanyInter("memory");
        Company company = new Company(1, "Niko", "Baki", null);
        CompanyImpl.companies.add(company);
        CompanyService service = new CompanyService();

        for (int i = 0; i < 200; i++) {

            employees.add(new Operator(i, "Yusif" + i, "Yusifov" + i, 20 + (i / 5), 500 + i * 20, EmployeeType.Operator));
        }
        for (int i = 0; i < 50; i++) {
            employees.add(new Manager(i, "Orxan" + i, "Quliyev" + i, 20 + (i / 6), 500 + i * 10, EmployeeType.Manager));
        }
        for (int i = 0; i < 10; i++) {
            employees.add(new TopManager(i, "Nihad" + i, "Askerli" + i, 20 + (i / 3), 500 + i * 100, EmployeeType.TopManager));
        }
        service.hireAllByUser(employees, 1);

        service.maxSalaryList(3000);
        System.out.println("-------------------------------------------");
        service.minSalary(1300);
    }
}