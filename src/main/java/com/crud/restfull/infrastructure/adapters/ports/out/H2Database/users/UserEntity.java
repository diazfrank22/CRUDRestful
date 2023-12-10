package com.crud.restfull.infrastructure.adapters.ports.out.H2Database.users;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

//@Data
@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name="users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long userId;
    private String name;
    private String email;
    private String password;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<PhoneEntity> phones;

    public UserEntity(Long userId, String name, String email, String password, List<PhoneEntity> phones) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phones = phones;
    }
}




