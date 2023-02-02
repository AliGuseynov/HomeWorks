package az.code.restapisecurity.repo;

import az.code.restapisecurity.models.RoleEntity;
import az.code.restapisecurity.models.UserEntity;
import az.code.restapisecurity.services.AuthServicesInterface;
import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Getter
@Component
@Profile("PostgreSQL")
@RequiredArgsConstructor
public class PostgreSqlRepo implements AuthServicesInterface {

    private final EntityManager em;

    @Override
    @Transactional
    public UserEntity adduser(UserEntity user) {
        em.merge(user);
        return user;
    }

    @Transactional
    public UserEntity updateUserRole(Long userID, Long RoleId) {

        UserEntity user = em.find(UserEntity.class, userID);

        RoleEntity role = em.find(RoleEntity.class, RoleId);

        if (!user.getRoles().contains(role)){
            user.getRoles().add(role);
        }

        em.merge(user);
        return user;
    }
}
