package com.example.demoemployeecrud.services;

import com.example.demoemployeecrud.dto.EmployeeDTO;
import com.example.demoemployeecrud.dto.TaskDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService implements IEmployeeServices {
    public List<EmployeeDTO> employeeDTOList = new ArrayList<>();

    @Override
    public List<EmployeeDTO> getAllEmployee() {
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

        return employeeDTOList;

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
    public Optional<Object> update(EmployeeDTO employeeDTO) {

        Optional<Object> employeeDTOS = employeeDTOList.stream()
                .filter(e -> e.getId() == employeeDTO.id).findAny()
                .map(e -> {
                    e.setName(employeeDTO.name);
                    return e;
                });

        return employeeDTOS;
    }


    @Override
    public List<EmployeeDTO> search(String name, String sortType) {
        if (sortType.equals("asc")) {
            List<EmployeeDTO> employeeDTOS = employeeDTOList.stream()
                    .filter(e -> e.getName().equals(name)).sorted().collect(Collectors.toList());

            return employeeDTOS;
//        } else if (sortType.equals("desc")) {
//            List<EmployeeDTO> employeeDTOS = employeeDTOList.stream()
//                    .filter(e -> e.getName().equals(name)).sorted(Comparator.reverseOrder())
//                    .collect(Collectors.toList());
//
//            return employeeDTOS;
//
//        }

//        EmployeeDTO employeeDTO = employeeDTOList.stream()
//                .filter(e -> name.equals(e.getName()))
//                .findAny().get();
        }
        return null;

    }

    @Override
    public EmployeeDTO save(EmployeeDTO employeeDTO) {
        return null;
    }
}
