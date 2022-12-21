package Repository;
import Helper.Helper;
import Model.Employee;
import Model.Manager;
import Model.Operator;
import Model.TopManager;
import java.util.List;
public class Repo {
    static List<Manager> managers= Helper.generateManager(50);
    static List<Operator> operator= Helper.generateOperator(200);
    static List<TopManager> topManagers= Helper.generateTopManager(10);
    public static List<Employee> employeeList= Helper.generateEmployee(managers,operator,topManagers);

}
