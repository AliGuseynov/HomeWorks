package az.code.restapisecurity.models;

import jakarta.persistence.*;
import lombok.*;

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

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private List<RoleEntity> roles;



    public String getRoles1(){
        String strOut = null;

        for(RoleEntity role: roles){
            strOut+= role.getRoleName() + ",";
        }

        strOut = strOut.substring(0, strOut.length()-1).toUpperCase();

        System.out.println(strOut);

        return strOut;

    }

}
