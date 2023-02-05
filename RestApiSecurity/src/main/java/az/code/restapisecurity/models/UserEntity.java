package az.code.restapisecurity.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

@Entity
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private List<RoleEntity> roles;



    public String[] getRoles1(){

        String[]arr = new String [roles.size()];

        //Converting List to Array
        roles.toArray(arr);


        return arr;

    }

}
