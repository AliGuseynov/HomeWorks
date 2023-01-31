package com.example.springwebapp.controller;

import com.example.springwebapp.dto.StudentDto;
import com.example.springwebapp.repo.StudentDaoList;
import com.example.springwebapp.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {


    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping
    List<StudentDto> getAll(){
        return studentService.getAll();
    }

    @GetMapping("/{id}")
    StudentDto getById(@PathVariable long id){
        return StudentDaoList.createList()
                .stream()
                .filter(x->x.getId().equals(id)).findAny().get();
    }

    @GetMapping("/byname")
    public ResponseEntity<List<StudentDto>> searchByName(@RequestParam() String name){
            List<StudentDto>list=studentService.searchByName(name);
            return ResponseEntity.ok(list);

    }

    @GetMapping("/bysurname")
    public ResponseEntity<List<StudentDto>> searchBySurname(@RequestParam() String surname){
        List<StudentDto>list=studentService.searchBySurname(surname);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/sort")
    public ResponseEntity<List<StudentDto>> sort(@RequestParam String name, @RequestParam String sortType){
        List<StudentDto>list=studentService.sort(name,sortType);
        return ResponseEntity.ok(list);
    }

    @PostMapping("/add")
    public  ResponseEntity<StudentDto> save(@RequestBody StudentDto studentDto){
        studentService.save(studentDto);
        return ResponseEntity.ok(studentDto);
    }


    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id){
        studentService.delete(id);
    }

    @PutMapping ("/update/{id}")
    public void update(@PathVariable long id,@RequestBody StudentDto studentDto){
        studentService.update(id,studentDto);
    }
}
