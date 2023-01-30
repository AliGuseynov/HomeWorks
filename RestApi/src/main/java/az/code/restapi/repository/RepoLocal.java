package az.code.restapi.repository;

import az.code.restapi.models.Employee;
import az.code.restapi.models.Task;
import jakarta.annotation.PostConstruct;
import lombok.Getter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Getter
@Service("RepoLocal")
public class RepoLocal {

    int lastId;
    private List<Employee> employees = new ArrayList<>();

    public Employee findEmployeeById(Long id){
        Employee out = this.employees.stream().filter(employee -> id.equals(employee.getId())).findFirst().orElse(null);
        System.out.println(out);
        return out;
    }

    public List<Employee> filterEmployees(String name, String surname, String sort, String sortType){

        List<Employee> employeeList = new ArrayList<>();

        employees.stream()
                .filter(employee -> name != null ? name.equals(employee.getName()): true)
                .filter(employee -> surname != null ? surname.equals(employee.getSurname()) : true)
//                .sorted(((o1, o2) -> )
                .collect(Collectors.toList());


        employeeList.forEach(System.out::println);

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

    @PostConstruct
    private void init(){
        employees = Seeder.getEmployees();

        lastId = employees.size();
    }
}
