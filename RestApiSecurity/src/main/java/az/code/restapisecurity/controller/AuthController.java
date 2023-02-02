package az.code.restapisecurity.controller;

import az.code.restapisecurity.models.UserEntity;
import az.code.restapisecurity.repo.UserRepo;
import az.code.restapisecurity.services.AuthServicesInterface;
import jakarta.annotation.PostConstruct;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    ApplicationContext applicationContext;

    AuthServicesInterface authRepo;

    @PostConstruct
    private void init(){
        authRepo = applicationContext.getBean(AuthServicesInterface.class);
    }

    @PostMapping("/register")
    public ResponseEntity<UserEntity> register(@RequestBody UserEntity user){

        System.out.println(user);
        return ResponseEntity.ok(authRepo.adduser(user));
    }

    @GetMapping("/getAdmin")
    @Secured("ROLE_ADMIN")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> getAdmin(){
        return ResponseEntity.ok("admin");
    }

    @PostMapping("/setRole")
    public UserEntity setRole(@RequestParam Long UserID, Long RoleID){


        return authRepo.updateUserRole(UserID, RoleID);
    }
    
}
