package UI;

import model.Employee;
import service.CompanyService;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class UI {
    CompanyService companyService = new CompanyService();

    private static Scanner scanner = new Scanner(System.in);

    public void run() {

        renderStageOption();

    }

    public void renderStageOption() {

        int input = 0;
        boolean whileRunner = true;

        while (whileRunner) {

            System.out.println("\n" +
                    "-  1. Add new Employee\n" +
                    "-  2. Add new Employees\n" +
                    "-  3. Remove employee\n" +
                    "-  4. Get All Employees\n" +
                    "-  5. Get All Employees Details\n" +
                    "-  6. Get Top N Salary\n" +
                    "-  7. Get Lowest N Salary\n" +
                    "-  9. Exit\n");

            System.out.print("Type (waiting...): ");

            input = scanner.nextInt();

            switch (input) {
                case 1:
                    renderAddNewEmployee();
                    run();
                    break;
                case 2:
                    renderAddNewEmployees();
                    run();
                    break;
                case 3:
                    renderRemoveEmployee();
                    run();
                    break;
                case 4:
                    renderGetAllEmployees();
                    run();
                    break;
                case 5:
                    renderGetAllEmployeesDetails();
                    run();
                    break;
                case 6:
                    getTopSalaryStaff();
                    run();
                    break;
                case 7:
                    getLowestSalaryStaff();
                    run();
                    break;
                case 9:
                    whileRunner = false;
                    break;
                default:
                    System.out.println("Input Wrong number!");
            }
        }
    }


    // 1
    public void renderAddNewEmployee() {
        System.out.println("Input name:");

        scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        System.out.println("Input position:");
        String position = scanner.nextLine();


        companyService.addEmployee(name, position);
    }

    // 2
    public void renderAddNewEmployees() {

        System.out.println("Input new Employees: ");

        do {

            renderAddNewEmployee();
            System.out.println("\n" +
                    "Would you like to continue?\n" +
                    "-  1. Yes\n" +
                    "-  2. No\n");

            scanner = new Scanner(System.in);
            if(scanner.nextInt() == 2)
                break;

        } while (true);
    }

    // 3
    public void renderRemoveEmployee() {
        System.out.println("Input count: ");

        scanner = new Scanner(System.in);
        companyService.removeEmployee(scanner.nextInt());
    }

    // 4
    public void renderGetAllEmployees() {

        List<Employee> tmpEmp = companyService.getAllEmployees();

        System.out.println("All Employees:");

        for (Employee e : tmpEmp)
            System.out.println(e.getName());
    }

    // 5
    public void renderGetAllEmployeesDetails() {

        LinkedHashMap<Integer, String> details = companyService.getEmployeesDetails();

        details.entrySet().forEach(e -> {
            System.out.println(e.getKey() + " " + e.getValue());
        });
    }

    // 6
    public void getTopSalaryStaff() {
        System.out.println("Input count: ");
        scanner = new Scanner(System.in);

        List<Employee> employees = companyService.getTopSalaryStaff(scanner.nextInt());

        for (Employee e : employees) {
            System.out.println(e.getName() + " " + e.getMonthSalary());
        }
    }

    public void getLowestSalaryStaff() {
        System.out.println("Input count: ");
        scanner = new Scanner(System.in);

        List<Employee> employees = companyService.getLowestSalaryStaff(scanner.nextInt());

        for (Employee e : employees) {
            System.out.println(e.getName() + " " + e.getMonthSalary());
        }

    }
}


