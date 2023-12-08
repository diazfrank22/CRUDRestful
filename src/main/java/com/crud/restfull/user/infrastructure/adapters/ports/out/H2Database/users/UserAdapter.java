package com.crud.restfull.user.infrastructure.adapters.ports.out.H2Database.users;

import com.crud.restfull.user.application.ports.out.UserOutPort;
import com.crud.restfull.user.common.PersistenceAdapter;
import com.crud.restfull.user.domain.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.stream.Collectors;

@PersistenceAdapter
public class UserAdapter implements UserOutPort {

    @Autowired
    private final UserRepository userRepository;

    public UserAdapter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> searchAllUsers() {

        return userRepository.findAll()
                             .stream()
                             .map(UserMapper::entityToDomain)
                             .collect(Collectors.toList());

    }
}