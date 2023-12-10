package com.crud.restfull.user.common;

import com.crud.restfull.user.domain.entities.User;
import org.springframework.http.ResponseEntity;

public class ApiResponse<T> {
    private boolean success;
    private String message;
    private T data;

    private ResponseEntity<User> body;

    public ApiResponse(boolean success, String message, ResponseEntity<User> body,  T data) {
        this.success = success;
        this.message = message;
        this.body = body;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ResponseEntity<User> getBody() {
        return body;
    }

    public void setBody(ResponseEntity<User> body) {
        this.body = body;
    }
}
