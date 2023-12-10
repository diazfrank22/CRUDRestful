package com.crud.restfull.application.services;

import com.crud.restfull.application.ports.out.UserOutPort;
import com.crud.restfull.common.UseCase;
import com.crud.restfull.application.ports.in.UserInPort;
import com.crud.restfull.domain.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;
@UseCase
public class UserService  implements UserInPort {

    @Autowired
    private final UserOutPort userOutPort;

    public UserService(UserOutPort userOutPort) {
        this.userOutPort = userOutPort;
    }

    @Override
    public List<User> searchAllUsers() {
        return userOutPort.searchAllUsers();
    }

    @Override
    public User addUser(UserInPort.parameterInPort command) {

        UserOutPort.parameterOutPort commandOut = new UserOutPort.parameterOutPort(command.getName(),command.getEmail(),command.getPassword(),command.getPhones());
        return userOutPort.addUser(commandOut);
    }

    @Override
    public ResponseEntity<User> updateUser(Long id, parameterInPort userUpdate) {

        UserOutPort.parameterOutPort userUpdateOutPort = new UserOutPort.parameterOutPort(userUpdate.getName(),userUpdate.getEmail(),userUpdate.getPassword(),userUpdate.getPhones());

        return userOutPort.updateUser(id, userUpdateOutPort);
    }

    @Override
    public ResponseEntity<String> deleteUser(Long id) {
        return userOutPort.deleteUser(id);
    }
}
