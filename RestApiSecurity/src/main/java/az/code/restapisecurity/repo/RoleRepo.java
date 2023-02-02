package az.code.restapisecurity.repo;

import az.code.restapisecurity.models.RoleEntity;
import az.code.restapisecurity.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepo extends JpaRepository<RoleEntity,Long> {

    Optional<RoleEntity> findById(String string);

}
