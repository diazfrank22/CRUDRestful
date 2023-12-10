package com.crud.restfull.infrastructure.adapters.ports.out.H2Database.users;

import com.crud.restfull.application.ports.out.UserOutPort;
import com.crud.restfull.common.PersistenceAdapter;
import com.crud.restfull.domain.entities.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
@PersistenceAdapter
public class UserAdapter implements UserOutPort {
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final PhoneRepository phoneRepository;

    public UserAdapter(UserRepository userRepository, PhoneRepository phoneRepository) {
        this.userRepository = userRepository;
        this.phoneRepository = phoneRepository;
    }
    @Override
    public List<User> searchAllUsers() {

        return userRepository.findAll()
                             .stream()
                             .map(UserMapper::entityToDomain)
                             .collect(Collectors.toList());
    }
    @Override
    public User addUser(UserOutPort.parameterOutPort command) {

        List<PhoneEntity> phonesList = command.getPhones()
                                              .stream()
                                              .map(phones->new PhoneEntity(phones.getNumber(), phones.getCitycode(), phones.getContrycode()))
                                              .collect(Collectors.toList());

        UserEntity newUser = new UserEntity(null, command.getName(), command.getEmail(), command.getPassword(), phonesList);

        UserEntity getResponse = userRepository.save(newUser);

        return UserMapper.entityToDomain(getResponse);

    }
    @Override
    public ResponseEntity<User> updateUser(Long id, parameterOutPort userUpdate) {

        //Haciendo el mapeo de EntityUser a User para devolver la repuesta
        return userRepository.findById(id)

                .map(usuarioExistente->{

                    User objUser = new User();
                    BeanUtils.copyProperties(usuarioExistente, objUser, "userId");

                    objUser.setName(userUpdate.getName());
                    objUser.setEmail(userUpdate.getEmail());
                    objUser.setPassword(userUpdate.getPassword());
                    objUser.setPhones(userUpdate.getPhones());

                    userRepository.save(usuarioExistente);

                    return ResponseEntity.ok(objUser);

                }).orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<String> deleteUser(Long id) {

           if (!userRepository.existsById(id))  return ResponseEntity.notFound().build();

               try {
                     userRepository.deleteById(id);
                     return ResponseEntity.ok("Usuario eliminado correctamente");
                   } catch (Exception e) {
                     return ResponseEntity.status(500).body("Error al eliminar el usuario: " + e.getMessage());
               }
    }
}