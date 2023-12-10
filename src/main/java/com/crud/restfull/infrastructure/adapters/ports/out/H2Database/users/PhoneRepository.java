package com.crud.restfull.infrastructure.adapters.ports.out.H2Database.users;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
@Configuration
public interface PhoneRepository extends JpaRepository<PhoneEntity,Long> {


}
