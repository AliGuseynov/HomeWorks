package homeworks.homework15.company.service;

import homeworks.homework15.company.business.CompanyRepompl;
import homeworks.homework15.company.business.ICompanyRepo;
import homeworks.homework15.company.model.Employee;

import java.util.List;
import java.util.Scanner;

public class CompanyService {
    Scanner scanner = new Scanner(System.in);
    ICompanyRepo iCompanyRepo = new CompanyRepompl();

    public void add() {
        System.out.println("Name:");
        String name = scanner.nextLine();

        System.out.println("Role:");
        String role = scanner.nextLine();
        iCompanyRepo.hire(name, role);

    }

    public void delete(int count) {
        iCompanyRepo.fire(count);

    }

    public List<Employee> getAllEmployee() {
        return iCompanyRepo.getAllEmployees();
    }

    public List<Employee> getTopSalaryStaff(int count) {

        return iCompanyRepo.getTopSalaryStaff(count);
    }

    public List<Employee> getLowestSalaryStaff(int count) {

        return iCompanyRepo.getLowestSalaryStaff(count);
    }
}
