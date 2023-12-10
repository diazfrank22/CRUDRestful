package com.crud.restfull.domain.entities;

import java.util.List;

public class User {

    private Long Id;
    private String name;
    private String email;
    private String password;
    private List<Phones> phones;

    public User() {
    }

    public User(Long Id, String name, String email, String password, List<Phones> phones) {
        this.Id = Id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phones = phones;
    }

    public Long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Phones> getPhones() {
        return phones;
    }

    public void setPhones(List<Phones> phones) {
        this.phones = phones;
    }
}
