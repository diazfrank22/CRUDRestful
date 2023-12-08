package com.crud.restfull.user.application.ports.in;

import com.crud.restfull.user.domain.entities.User;

import java.util.List;

public interface UserInPort {
    public List<User> searchAllUsers ();
}
