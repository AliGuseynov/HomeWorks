package az.code.restapisecurity.repo;

import az.code.restapisecurity.models.RoleEntity;
import az.code.restapisecurity.models.UserEntity;
import az.code.restapisecurity.services.AuthServicesInterface;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Getter
@Component
@Profile("local")
@RequiredArgsConstructor
public class LocalRepo implements AuthServicesInterface {


    FileReader fileReader;

    HashMap<String, UserEntity> usersMap = new HashMap<>();

    List<UserEntity> usersList = new ArrayList<>();


    @PostConstruct
    private void init() {
        {
            try {
                fileReader = new FileReader("files\\users.txt");


                BufferedReader br = new BufferedReader(fileReader);
                String line;
                while ((line = br.readLine()) != null) {
                    String[] strings = line.split(",");

                    List<RoleEntity> roles = List.of(RoleEntity.builder().roleName(strings[2]).build());

                    UserEntity user = UserEntity.builder().username(strings[0]).password(strings[1])
                            .roles(roles).build();

                    usersMap.put(strings[0], user);

                    usersList.add(user);

                }

                br.close();
                fileReader.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public UserEntity adduser(UserEntity user) {
        return null;
    }

    @Override
    public UserEntity updateUserRole(Long userID, Long RoleId) {
        return null;
    }

    @Override
    public Optional<UserEntity> findByUsername(String string, UserRepo userRepo) {

        UserEntity user = usersMap.get(string);
        return Optional.of(user);
    }

    @Override
    public Optional<UserEntity> findById(String string, UserRepo userRepo) {
        return Optional.empty();
    }
}



