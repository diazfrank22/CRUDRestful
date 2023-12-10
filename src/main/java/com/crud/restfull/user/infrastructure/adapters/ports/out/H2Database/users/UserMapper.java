package com.crud.restfull.user.infrastructure.adapters.ports.out.H2Database.users;

import com.crud.restfull.user.domain.entities.Phones;
import com.crud.restfull.user.domain.entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

    public static User entityToDomain(UserEntity userEntity) {

        List<Phones> PhonesList = userEntity.getPhones()
                                          .stream()
                                          .map(phone-> new Phones(phone.getPhoneId(), phone.getNumber(),phone.getCitycode(),phone.getContrycode())).collect(Collectors.toList());

        return new User(userEntity.getUserId(), userEntity.getName(), userEntity.getEmail(), userEntity.getPassword(), PhonesList);

    }

    public static UserEntity domainToEntity(User user) {

         List<PhoneEntity> getPhone = (List<PhoneEntity>) user.getPhones().stream().map(obj->user.getPhones());

        return new UserEntity( user.getId(),
                               user.getName(),
                               user.getEmail(),
                               user.getPassword(),
                               getPhone);
    }


}
