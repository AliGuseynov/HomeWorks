import company.Company;
import company.CompanyConfig;
import company.employee.Employee;
import datas.GenerateManagerDatas;
import datas.GenerateOperatorDatas;
import datas.GenerateTopManagerDatas;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> topManagers = GenerateTopManagerDatas.topManagerListGenerator(10);
        List<Employee> managers = GenerateManagerDatas.managerListGenerator(50);
        List<Employee> operators = GenerateOperatorDatas.operatorListGenerator(200);

        List<List<Employee>> emplooyesList = new ArrayList<>();
        emplooyesList.add(topManagers); emplooyesList.add(managers); emplooyesList.add(operators);

        Company company = new Company("mansa",emplooyesList);

        System.out.println(topManagers);
        topManagers.get(2).onHire();
        System.out.println(GenerateTopManagerDatas.topManagerGenerator());
    }
}
