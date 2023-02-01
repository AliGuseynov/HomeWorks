package az.code.studentdbrest.controller;

import az.code.studentdbrest.service.impl.DBEmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final ObjectMapper objectMapper;
    @Autowired
    DBEmployeeService DBEmployeeService;
}
