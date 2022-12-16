package homework15_12;

import homework15_12.services.CompanyService;

import java.util.Scanner;

public class Homework15_12Runner {


    CompanyService service = new CompanyService();
    public void run(){


        CompanyService service = this.service;
        System.out.println("Functions========================\n" +
                "1 - Hire employee\n" +
                "2 - Hire All\n" +
                "3 - Fire employees\n" +
                "4 - Highest salary staff\n" +
                "5 - Lowest salary staff\n" +
                "6 - Get all employees");
        System.out.print("Enter option: ");

        Scanner scanner = new Scanner(System.in);

        boolean whileBreaker = true;
        while (whileBreaker){
            Integer input = scanner.nextInt();
            switch (input){
                case 1: hire(service);
                whileBreaker = false;
                break;
                case 2: service.hireAll();
                    System.out.print("Enter new option: ");
                    break;
                case 3:

                    System.out.print("İşdən kənarlaşdırılan əməkdaş sayını daxil edin: ");
                    service.fire(scanner.nextInt());
                    System.out.print("Enter new option: ");
                    break;
                case 4:

                    System.out.print("Əməkdaş sayın daxil edin: ");
                    service.getTopSalaryStaff(scanner.nextInt());
                    System.out.print("Enter new option: ");
                    break;
                case 5:
                    System.out.print("Əməkdaş sayın daxil edin: ");
                    service.getLowestSalaryStaff(scanner.nextInt());
                    System.out.print("Enter new option: ");
                    break;
                case 6: service.returnAllEmployees();
                    System.out.print("Enter new option: ");
                    break;
                default:
                    System.out.print("You entered wrong option... " +
                            "\nEnter option: ");

            }
        }}

    public void hire(CompanyService service){
        Scanner scanner = new Scanner(System.in);
        int input = 0;
        int salary = 0;

        boolean whilebreaker = true;
        while (whilebreaker){
            System.out.print("1 - operator; 2 - manager; 3 - top manager" +
                    "\nTipi daxil edin: ");
            input = scanner.nextInt();
            if (input>0 && input<4){
                whilebreaker = false;
                break;
            }}
        String name = null;
        System.out.print("Adı daxil edin: ");
        name = scanner.nextLine(); // there's error
        name = scanner.nextLine();
        while (salary<350){
            System.out.print("Maaşı daxil edin (Minimal 350): ");
            salary = scanner.nextInt();
        }
        service.hire(input,name, salary);
        run();
    }




}
