package com.crud.restfull.infrastructure.adapters.ports.in;

import com.crud.restfull.common.WebAdapter;
import com.crud.restfull.application.ports.in.UserInPort;
import com.crud.restfull.common.ApiResponse;
import com.crud.restfull.domain.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@WebAdapter
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserInPort userInPort;

    @Autowired
    public UserController(UserInPort userInPort) {
        this.userInPort = userInPort;
    }

    @GetMapping
    public List<ResponseEntity> getAllUsers() {

        Optional<List<User>> getAllUsers = Optional.of(userInPort.searchAllUsers());

        if (!getAllUsers.isPresent())
            return Collections.singletonList(new ResponseEntity<>(getAllUsers, HttpStatus.NOT_FOUND));

        if (getAllUsers.get().isEmpty())
            return Collections.singletonList(new ResponseEntity<>(getAllUsers, HttpStatus.NO_CONTENT));

        return Collections.singletonList(new ResponseEntity<>(getAllUsers, HttpStatus.OK));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<String>> addUser(@RequestBody  UserInPort.parameterInPort parameters) {

        UserInPort.parameterInPort command = new UserInPort.parameterInPort(parameters);

        try {
            Optional<User> userAdded = Optional.of(userInPort.addUser(command));
            // Verificar si el guardado fue exitoso
            if (userAdded.isPresent()) {
                ApiResponse<String> successResponse = new ApiResponse<>(true, "Usuario guardado con exito", null, LocalDate.now().toString());
                return new ResponseEntity<>(successResponse, HttpStatus.CREATED);
            }

            if (!userAdded.isPresent()) {
                ApiResponse<String> errorResponse = new ApiResponse<>(false, "Error al guardar el usuario", null, LocalDate.now().toString());
                return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            // Manejar excepciones específicas según tus necesidades
            ApiResponse<String> errorResponse = new ApiResponse<>(false, "Error al guardar el usuario: " + e.getMessage() + "", null, LocalDate.now().toString());
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> updateUser(@PathVariable Long id, @RequestBody UserInPort.parameterInPort userUpdate) {

        try {
            ResponseEntity<User> result = userInPort.updateUser(id, userUpdate);
            ApiResponse<String> successResponse = new ApiResponse<>(true, "Mensaje modificado con exito", result, LocalDate.now().toString());
            return new ResponseEntity<>(successResponse, HttpStatus.CREATED);
        } catch (Exception e) {
            ApiResponse<String> errorResponse = new ApiResponse<>(false, e.getMessage(), null, LocalDate.now().toString());
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_MODIFIED);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteUser(@PathVariable Long id) {

       try {

            ResponseEntity<String> response = userInPort.deleteUser(id);

            if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
                ApiResponse<String> errorResponse = new ApiResponse<>(false, "Registro a eliminar no existe", null, LocalDate.now().toString());
                return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
            }

            if (response.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR) {
                ApiResponse<String> errorResponse = new ApiResponse<>(false, "error interno del servidor (código 500).", null, LocalDate.now().toString());
                return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
            }

            if (response.getStatusCode() == HttpStatus.OK) {
                ApiResponse<String> Response = new ApiResponse<>(true, response.getBody(), null, LocalDate.now().toString());
                return new ResponseEntity<>(Response, HttpStatus.OK);
            }

        } catch (HttpServerErrorException ex) {

            if (ex.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR) {
                System.out.println("La solicitud resultó en un error interno del servidor (código 500).");
            }
        }

        ApiResponse<String> Response = new ApiResponse<>(true, "Usuario eliminado correctamente", null, LocalDate.now().toString());
        return new ResponseEntity<>(Response, HttpStatus.OK);

    }
}