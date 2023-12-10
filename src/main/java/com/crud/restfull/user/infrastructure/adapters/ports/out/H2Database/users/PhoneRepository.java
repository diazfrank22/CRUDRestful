package com.crud.restfull.user.infrastructure.adapters.ports.out.H2Database.users;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Configuration
public interface PhoneRepository extends JpaRepository<PhoneEntity,Long> {


}
