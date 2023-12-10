package com.crud.restfull.application.ports.out;

import com.crud.restfull.domain.entities.Phones;
import com.crud.restfull.domain.entities.User;
import lombok.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserOutPort {

    public List<User> searchAllUsers ();

    public User addUser(UserOutPort.parameterOutPort commandOut);
    public ResponseEntity<User> updateUser(Long id, parameterOutPort userUpdate);
    public ResponseEntity<String> deleteUser(Long id);

    @Data
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    class parameterOutPort {
        String name;
        String email;
        String password;
        List<Phones> phones;

    }

}
