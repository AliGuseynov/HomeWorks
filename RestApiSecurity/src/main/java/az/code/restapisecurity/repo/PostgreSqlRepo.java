package az.code.restapisecurity.repo;

import az.code.restapisecurity.models.RoleEntity;
import az.code.restapisecurity.models.UserEntity;
import az.code.restapisecurity.services.AuthServicesInterface;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
@Component
@Profile("PostgreSQL")
@RequiredArgsConstructor
public class PostgreSqlRepo implements AuthServicesInterface {

    private final EntityManager em;
    @Autowired
    ApplicationContext applicationContext;


    @Override
    @Transactional
    public UserEntity adduser(UserEntity user) {
        BCryptPasswordEncoder encoder = applicationContext.getBean(BCryptPasswordEncoder.class);
        user = user.toBuilder().password(encoder.encode(user.getPassword())).build();
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

    @Override
    public Optional<UserEntity> findByUsername(String string, UserRepo userRepo) {
        return userRepo.findByUsername(string);
    }

    @Override
    public Optional<UserEntity> findById(String string, UserRepo userRepo) {
        return Optional.empty();
    }

}
