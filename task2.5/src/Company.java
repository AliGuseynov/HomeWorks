import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Company {
    static List<Employee> employees = new ArrayList<>();

    public static void hire() {
        TopManager m = new TopManager(3000, 50);
        employees.add(m);
        m.onHire();
    }

    ;

    public static void hireAll() {
        ArrayList<Employee> addEmp = new ArrayList<Employee>(
                Arrays.asList(new Manager(12, 233), new Manager(23, 465)));
        employees.addAll(addEmp);
//        System.out.println(employees.size());
        ;
    }

    public static void fire(int count) {
        employees.subList(0, 10).clear();
//        System.out.println(employees);
    }


  public static void  getTopSalaryStaff(int count) {
      Collections.sort(employees);
      for (int i=0; i < count; i++) {
          System.out.println(employees.get(i));
      }
    }

    public static void getLowestSalaryStaff(int count) {
        Collections.sort(employees);
        for (int i=employees.size()-1; i > employees.size()-count-1; i--) {
            System.out.println(employees.get(i));
        }

    }


}