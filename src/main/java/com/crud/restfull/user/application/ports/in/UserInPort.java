package com.crud.restfull.user.application.ports.in;

import com.crud.restfull.user.domain.entities.Phones;
import com.crud.restfull.user.domain.entities.User;
import lombok.*;
import org.springframework.http.ResponseEntity;

import java.lang.reflect.Parameter;
import java.util.List;

public interface UserInPort {

    public List<User> searchAllUsers();

    public User addUser(parameterInPort command);
    public ResponseEntity<User> updateUser(Long id, User userUpdate);
    public ResponseEntity<String> deleteUser(Long id);

    @Data
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    class parameterInPort {
        String name;
        String email;
        String password;
        List<Phones> phones;

    }
}
