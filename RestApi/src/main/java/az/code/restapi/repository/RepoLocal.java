package az.code.restapi.repository;

import az.code.restapi.models.Employee;
import az.code.restapi.models.Task;
import jakarta.annotation.PostConstruct;
import lombok.Getter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
@Getter
@Service("repo")
@Profile("local")
public class RepoLocal implements RepoInterface{

    int lastId;
    private List<Employee> employees = new ArrayList<>();

    private List<Task> tasks = new ArrayList<>();

    public Employee findEmployeeById(Long id){
        Employee out = this.employees.stream().filter(employee -> id.equals(employee.getId())).findFirst().orElse(null);
        System.out.println(out);
        return out;
    }

    public List<Employee> filterEmployees(String name, String surname, String sort, String sortType){

        List<Employee> employeeList = new ArrayList<>();

        final String sortS = sort;

        employeeList = employees.stream()
                .filter(employee -> name != null ? employee.getName().toLowerCase().contains(name.toLowerCase()): true)
                .filter(employee -> surname != null ? employee.getSurname().toLowerCase().contains(surname.toLowerCase()) : true)
                .sorted(((o1, o2) ->
                        sortS == null ? 0 :
                        sortS.equalsIgnoreCase("name") ? o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase()):
                        sortS.equalsIgnoreCase("surname") ? o1.getSurname().toLowerCase().compareTo(o2.getSurname().toLowerCase())
                                : 0
                        ))
                .collect(Collectors.toList());

        if (
                ((sortType != null) && sortType.equalsIgnoreCase("desc"))
        ){
            Collections.reverse(employeeList);
        }


        employeeList.forEach(System.out::println);
        System.out.println("================ Query end");

                return employeeList;
    }

    public Employee addEmploee(Employee employee){
        employee =  employee.toBuilder().id(Long.parseLong(String.valueOf(lastId++))).build();
        System.out.println(employee);
        employees.add(employee);
        return employee;
    }

    public Employee updateEmployee(Long id, Employee employeeTemp){
        Employee.EmployeeBuilder employee = findEmployeeById(id).toBuilder();
        if ( employeeTemp.getName() != null){
            employee.name(employeeTemp.getName());
        } else if ( employeeTemp.getSurname()!= null){
            employee.surname(employeeTemp.getSurname());
        }
        return employee.build();
    }

    public Employee deleteEmployee(Long id){

        Employee employeeReturn = null;

        for (int i = 0; i < employees.size(); i++){
           if (employees.get(i).getId() == id){
               employeeReturn = employees.get(i);
               employees.remove(i);
               break;
           }
        }
        return employeeReturn;
    }

    @Override
    public List<Task> getTasks(Long id) {
        return findEmployeeById(id).getTaskList();
    }

    @Override
    public Task addTask(Task task) {
        return task;
    }

    @PostConstruct
    private void init(){
        employees = Seeder.getEmployees();

        lastId = employees.size();
    }
}
