package com.crud.restfull.infrastructure.adapters.ports.in;

import com.crud.restfull.application.ports.in.UserInPort;
import com.crud.restfull.domain.entities.Phones;
import com.crud.restfull.domain.entities.User;
import com.crud.restfull.infrastructure.adapters.ports.out.H2Database.users.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Mock
    private UserInPort userInPort;
    @InjectMocks
    private UserController userController;


    @Test
    void findAllTest(){

        //Given

        List<PhoneEntity> phone = List.of(new PhoneEntity("1126978596", "1824", "54"),
                                          new PhoneEntity("1126978589", "1824", "54"));

        List<UserEntity> expectedDomain = List.of(new UserEntity(1l, "Frank", "diazfrank22@hotmail.com", "1234", phone));

        List<User> expected = expectedDomain.stream()
                .map(user -> new User(user.getUserId(),
                                user.getName(),
                                user.getEmail(),
                                user.getPassword(),
                                user.getPhones().stream()
                                        .map(phones -> new Phones(1l,
                                                phones.getNumber(),
                                                phones.getCitycode(),
                                                phones.getContrycode())).collect(Collectors.toList())

                        )
                ).collect(Collectors.toList());

        Mockito.when(userInPort.searchAllUsers()).thenReturn(expected);
        //When

        List<ResponseEntity> response = userController.getAllUsers();
        Optional<List<User>>  optionalExpected = Optional.of(expected);

        assertEquals(HttpStatus.OK, response.get(0).getStatusCode());
        assertEquals(response.get(0).getBody().toString(), optionalExpected.toString());

    }
}