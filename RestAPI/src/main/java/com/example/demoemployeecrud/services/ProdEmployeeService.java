package com.example.demoemployeecrud.services;

import com.example.demoemployeecrud.dto.EmployeeDTO;
import com.example.demoemployeecrud.dto.TaskDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
//@Profile("!local")
public class ProdEmployeeService implements IEmployeeServices {
    public static List<EmployeeDTO> employeeDTOList = new ArrayList<>();

    @Override
    public void getAllEmployee() {
        List<TaskDTO> taskDTOList1 = List.of(TaskDTO.builder().id(100l).title("task1").description("description1")
                        .dueDate(LocalDate.of(2023, 2, 20)).build(),
                TaskDTO.builder().id(200l).title("task2").description("description2")
                        .dueDate(LocalDate.of(2023, 3, 20)).build());

        List<TaskDTO> taskDTOList2 = List.of(TaskDTO.builder().id(300l).title("task3").description("description3")
                        .dueDate(LocalDate.of(2023, 4, 20)).build(),
                TaskDTO.builder().id(400l).title("task4").description("description4")
                        .dueDate(LocalDate.of(2023, 5, 20)).build());


        employeeDTOList.add(EmployeeDTO.builder().id(1l).name("leyla").surname("khalilli").taskDTOList(taskDTOList1).build());
        employeeDTOList.add(EmployeeDTO.builder().id(2l).name("sabi").surname("suleymanli").taskDTOList(taskDTOList2).build());
        employeeDTOList.add(EmployeeDTO.builder().id(3l).name("leyla").surname("xelilzade").taskDTOList(taskDTOList2).build());

//        return employeeDTOList;

    }

    @Override
    public EmployeeDTO getById(long id) {
        EmployeeDTO employeeDTO = employeeDTOList.stream()
                .filter(e -> e.getId() == id).findAny().get();
        return employeeDTO;
    }

    @Override
    public List<EmployeeDTO> delete(long id) {

        Optional<Object> employeeDTO = employeeDTOList.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .map(e -> {
                    employeeDTOList.remove(e);
                    return e;
                });
        return employeeDTOList;


    }

    @Override
    public void update(long id,EmployeeDTO employeeDTO) {

//        EmployeeDTO employeeDTOS = employeeDTOList.stream()
//                .filter(e -> e.getId() == employeeDTO.id).findAny().get();
        for (EmployeeDTO employeeDTOS : employeeDTOList) {
            if (employeeDTO.id ==id){
                employeeDTOS.setName(employeeDTO.getName());
                employeeDTOS.setSurname(employeeDTO.getSurname());
                employeeDTOS.setTaskDTOList(employeeDTO.getTaskDTOList());
            }
        }

    }


    @Override
    public List<EmployeeDTO> search(String name, String sortType) {
        if (sortType.equals("asc")) {
            List<EmployeeDTO> employeeDTOS = employeeDTOList.stream()
                    .filter(e -> e.getName().equals(name)).
                    sorted(Comparator.comparing(EmployeeDTO::getName).reversed()).collect(Collectors.toList());
            return employeeDTOS;
        } else if (sortType.equals("desc")) {
            List<EmployeeDTO> employeeDTOS = employeeDTOList.stream()
                    .filter(e -> e.getName().equals(name)).
                    sorted(Comparator.comparing(EmployeeDTO::getName)).collect(Collectors.toList());
            Collections.reverse(employeeDTOS);
            return employeeDTOS;
        }

        return null;

    }

    @Override
    public void save(EmployeeDTO employeeDTO) {

        employeeDTOList.add(EmployeeDTO.builder().name(employeeDTO.getName())
                .surname(employeeDTO.getSurname())
                .taskDTOList(employeeDTO.getTaskDTOList()).build());
    }
}
