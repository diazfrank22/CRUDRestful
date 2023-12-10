package com.crud.restfull.user.infrastructure.adapters.ports.out.H2Database.users;

import com.crud.restfull.user.domain.entities.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
@Configuration
public interface UserRepository extends JpaRepository<UserEntity,Long> {



    UserEntity save(User user);
}
