package az.code.restapisecurity.services;

import az.code.restapisecurity.models.UserEntity;
import az.code.restapisecurity.repo.UserRepo;

import java.util.Optional;

public interface AuthServicesInterface {

    public UserEntity adduser(UserEntity user);
    public UserEntity updateUserRole(Long userID, Long RoleId);

    public Optional<UserEntity> findByUsername(String string, UserRepo userRepo);

    Optional<UserEntity> findById(String string, UserRepo userRepo);


}
