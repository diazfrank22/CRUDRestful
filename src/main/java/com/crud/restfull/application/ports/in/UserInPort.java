package com.crud.restfull.application.ports.in;

import com.crud.restfull.domain.entities.Phones;
import com.crud.restfull.domain.entities.User;
import lombok.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserInPort {

    public List<User> searchAllUsers();

    public User addUser(parameterInPort command);
    public ResponseEntity<User> updateUser(Long id, parameterInPort userUpdate);
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

        public parameterInPort(parameterInPort parameters) {

            this.name = parameters.getName();
            this.email = parameters.getEmail();
            this.password = parameters.getPassword();
            this.phones =   parameters.getPhones();
        }
    }
}
