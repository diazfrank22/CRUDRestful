package com.crud.restfull.user;

import com.crud.restfull.user.infrastructure.adapters.ports.out.H2Database.users.PhoneEntity;
import com.crud.restfull.user.infrastructure.adapters.ports.out.H2Database.users.UserEntity;
import com.crud.restfull.user.infrastructure.adapters.ports.out.H2Database.users.UserRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class StartDatabaseWithData implements InitializingBean {
    private final UserRepository userRepository;
    public StartDatabaseWithData(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        //PhoneEntity phone = new PhoneEntity("1126978596", "1824", "54");
        this.userRepository.save(new UserEntity("Frank", "diazfrank22@hotmail.com", "1234"));

    }
}
