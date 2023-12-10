package com.crud.restfull.infrastructure.adapters.ports.out.H2Database.users;

import com.crud.restfull.domain.entities.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
@Configuration
public interface UserRepository extends JpaRepository<UserEntity,Long> {



    UserEntity save(User user);
}
