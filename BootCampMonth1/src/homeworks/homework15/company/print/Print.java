package homeworks.homework15.company.print;

import homeworks.homework15.company.model.Employee;
import homeworks.homework15.company.service.CompanyService;

import java.util.List;
import java.util.Scanner;

public class Print {
    Scanner scanner = new Scanner(System.in);

    //    ICompanyRepo iCompany = new CompanyRepompl();
    CompanyService companyService = new CompanyService();

    public void menu() {

        int n = 0;
        while (n < 10) {
            System.out.println("Emeliyyat secin:\n1 Bir yeni işçi əlavə edin\n" +
                    "2 List işçi əlavə edin\n" +
                    "3 Işçi işdən kənarlaşdırılır\n" +
                    "4 ən çox maaş alanlar\n" +
                    "5 ən az maaş alanlar\n" +
                    "6 Işçilər:\n");
            System.out.print("Emeliyyat:");
            int emeliyyat = scanner.nextInt();


            switch (emeliyyat) {
                case 1:
//                System.out.println("enter name and role");
//                String name = scanner.nextLine();
//
//                System.out.println("Role:");
//                String role = scanner.nextLine();

                    companyService.add();
                    break;
                case 2:
                    break;
                case 3:
                    System.out.println("Count:");
                    companyService.delete(scanner.nextInt());
                    break;
                case 4:
                    System.out.println("Count:");

                    List<Employee> employeeList = companyService.getTopSalaryStaff(scanner.nextInt());

                    for (Employee employee : employeeList) {
                        System.out.println(employee.getMonthSalary());
                    }
                    break;
                case 5:

                    System.out.println("Count:");

                    List<Employee> employees = companyService.getLowestSalaryStaff(scanner.nextInt());

                    for (Employee employee : employees) {
                        System.out.println(employee.getMonthSalary());
                    }
                    break;
                case 6:
                    companyService.getAllEmployee();
                    break;

            }

        }

    }
}

