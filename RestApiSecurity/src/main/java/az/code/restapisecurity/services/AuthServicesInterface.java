package az.code.restapisecurity.services;

import az.code.restapisecurity.models.UserEntity;

public interface AuthServicesInterface {

    public UserEntity adduser(UserEntity user);
    public UserEntity updateUserRole(Long userID, Long RoleId);

}
