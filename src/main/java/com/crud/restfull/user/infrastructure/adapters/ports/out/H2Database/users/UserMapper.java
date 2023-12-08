package com.crud.restfull.user.infrastructure.adapters.ports.out.H2Database.users;

import com.crud.restfull.user.domain.entities.Phones;
import com.crud.restfull.user.domain.entities.User;

public class UserMapper {

    public static User entityToDomain(UserEntity userEntity) {

//       Phones objPhone = new Phones(userEntity.getPhone().getNumber(),
//                                    userEntity.getPhone().getCitycode(),
//                                    userEntity.getPhone().getContrycode());

        return new User(userEntity.getName(), userEntity.getEmail(), userEntity.getPassword());

    }

    public static UserEntity domainToEntity(User user) {

        return new UserEntity( user.getName(),
                               user.getEmail(),
                               user.getPassword());
    }
}
