package az.code.restapisecurity.repo;

import az.code.restapisecurity.models.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<UserEntity,Long> {

    Optional<UserEntity> findByUsername(String string);

    Optional<UserEntity> findById(String string);
}