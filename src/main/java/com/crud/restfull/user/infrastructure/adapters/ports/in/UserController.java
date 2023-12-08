package com.crud.restfull.user.infrastructure.adapters.ports.in;

import com.crud.restfull.user.application.ports.in.UserInPort;
import com.crud.restfull.user.common.WebAdapter;
import com.crud.restfull.user.domain.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@WebAdapter
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private final UserInPort userInPort;


    public UserController(UserInPort userInPort) {
        this.userInPort = userInPort;
    }


    @GetMapping
    public List<ResponseEntity> getAllUsers() {

        Optional<List<User>> getAllUsers = Optional.of(userInPort.searchAllUsers());

        if (!getAllUsers.isPresent()) return Collections.singletonList(new ResponseEntity<>(getAllUsers, HttpStatus.NOT_FOUND));

        if (getAllUsers.get().isEmpty()) return Collections.singletonList(new ResponseEntity<>(getAllUsers, HttpStatus.NO_CONTENT));

        return Collections.singletonList(new ResponseEntity<>(getAllUsers, HttpStatus.OK));
    }


}