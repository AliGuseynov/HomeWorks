package company;

import company.employee.Employee;
import datas.GenerateManagerDatas;
import datas.GenerateOperatorDatas;
import datas.GenerateTopManagerDatas;

import java.util.ArrayList;
import java.util.List;

public class CompanyConfig {

    public static Employee hire(String workName) {
        if (workName.equals("Top Manager")) {
            return GenerateTopManagerDatas.topManagerGenerator();
        } else if (workName.equals("Manager")) {
            return GenerateManagerDatas.managerGenerator();
        } else if (workName.equals("Operator")) {
            return GenerateOperatorDatas.operatorGenerator();
        } else {
            return null;
        }
    }

    public static List<Employee> hireAll(String workName, int count) {
        if (workName.equals("Top Manager")) {
            return GenerateTopManagerDatas.topManagerListGenerator(count);
        } else if (workName.equals("Manager")) {
            return GenerateManagerDatas.managerListGenerator(count);
        } else if (workName.equals("Operator")) {
            return GenerateOperatorDatas.operatorListGenerator(count);
        } else {
            return null;
        }
    }

    public static boolean fire(List<Employee> employeeList, int count) {
        employeeList.remove(count);
        return true;
    }

    public List<Employee> getSalary(List<Employee> employeeList, int salary) {
        List<Employee> result = new ArrayList<>();
        for (Employee employee : employeeList) {
            if (employee.getMonthlySalary() == salary) {
                result.add(employee);
            }
        }
        return result;
    }


}
