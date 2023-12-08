package com.crud.restfull.user.application.ports.out;

import com.crud.restfull.user.domain.entities.User;

import java.util.List;

public interface UserOutPort {

    public List<User> searchAllUsers ();

}
