package com.crud.restfull;

import com.crud.restfull.infrastructure.adapters.ports.out.H2Database.users.PhoneEntity;
import com.crud.restfull.infrastructure.adapters.ports.out.H2Database.users.PhoneRepository;
import com.crud.restfull.infrastructure.adapters.ports.out.H2Database.users.UserEntity;
import com.crud.restfull.infrastructure.adapters.ports.out.H2Database.users.UserRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class StartDatabaseWithData implements InitializingBean {

    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final PhoneRepository phoneRepository;
    public StartDatabaseWithData(UserRepository userRepository, PhoneRepository phoneRepository) {
        this.userRepository = userRepository;
        this.phoneRepository = phoneRepository;
    }

    @Transactional
    public void afterPropertiesSet() throws Exception {

      List<PhoneEntity> phone = List.of(new PhoneEntity("1126978596", "1824", "54"));
      this.userRepository.save(new UserEntity(null, "Frank", "diazfrank22@hotmail.com", "1234", phone));

    }
}
