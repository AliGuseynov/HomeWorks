package Helper;

import Model.Employee;
import Model.Manager;
import Model.Operator;
import Model.TopManager;

import java.util.ArrayList;
import java.util.List;

public class Helper {

    public static List<Manager> generateManager(int count){
        List<Manager> managers=new ArrayList<>();
        for (int i=0;i<=count;i++){
            Manager manager=new Manager("Manager_"+i,getRandomInteger(1000, 500));
            managers.add(manager);
        }
        return managers;
    }

    public static List<TopManager> generateTopManager(int count){
        List<TopManager> topManagers=new ArrayList<>();
        for (int i=0;i<=count;i++){
            TopManager topmanager=new TopManager("Top_Manager_"+i,getRandomInteger(2500,1000));
            topManagers.add(topmanager);
        }
        return topManagers;
    }

    public static List<Operator> generateOperator(int count){
        List<Operator> operators=new ArrayList<>();
        for (int i=0;i<=count;i++){
            Operator operator=new Operator("Operator_"+i,getRandomInteger(1500,1000));
            operators.add(operator);
        }
        return operators;
    }

    public static List<Employee> generateEmployee(List<Manager> managers,List<Operator> operators,List<TopManager> topManagers){
        List<Employee> employess=new ArrayList<>();
        List<Manager> managers1=generateManager(50);
        List<Operator> operators1=generateOperator(200);
        List<TopManager> topManagers1=generateTopManager(10);
        employess.addAll(managers1);
        employess.addAll(operators1);
        employess.addAll(topManagers1);
        return employess;
    }
    public static int getRandomInteger(int maximum, int minimum)
    {
        return ((int) (Math.random()*(maximum - minimum))) + minimum;
    }

}
