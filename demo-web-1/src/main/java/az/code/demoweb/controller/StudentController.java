package az.code.demoweb.controller;
import az.code.demoweb.dto.StudentDto;
import az.code.demoweb.exception.StudentNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    @GetMapping
    public ResponseEntity<List<StudentDto>> getAll(){
        return ResponseEntity.ok(List.of(StudentDto.builder().id(1l).name("Behlul").surname("Eyvazli").build(),
                StudentDto.builder().id(2l).name("Behlul2").surname("Eyvazli2").build()));
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<StudentDto> getById(@PathVariable long id){
//        Optional<StudentDto> res = id == 1 ? Optional.of(StudentDto.builder().id(1l).name("Behlul").surname("Eyvazli").build()) : Optional.empty();
//        return new ResponseEntity<>(HttpStatus.CONFLICT);
//    }
//    @GetMapping
//    public ResponseEntity<List<StudentDto>> search(@RequestParam(required = false) String name){
//
//         return ResponseEntity.ok(List.of(StudentDto.builder().id(1l).name(name).surname("Eyvazli").build(),
//                 StudentDto.builder().id(2l).name(name).surname("Eyvazli2").build()));
//    }
//
//    @PostMapping
//    public ResponseEntity<StudentDto> saveStudent(@RequestBody StudentDto studentDto){
//        return ResponseEntity.ok(studentDto.toBuilder().id(100l).build());
//    }
//    @DeleteMapping("/{id}")
//    public ResponseEntity<StudentDto> deleteById(@PathVariable long id){
//        throw new StudentNotFoundException();
//    }

}
