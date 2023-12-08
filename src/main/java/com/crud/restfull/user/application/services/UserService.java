package com.crud.restfull.user.application.services;

import com.crud.restfull.user.application.ports.in.UserInPort;
import com.crud.restfull.user.application.ports.out.UserOutPort;
import com.crud.restfull.user.common.UseCase;
import com.crud.restfull.user.domain.entities.User;
import org.springframework.beans.factory.annotation.Autowired;

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

}
