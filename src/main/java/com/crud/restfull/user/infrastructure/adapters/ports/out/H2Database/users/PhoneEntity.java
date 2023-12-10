package com.crud.restfull.user.infrastructure.adapters.ports.out.H2Database.users;

import jakarta.persistence.*;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="phones")
public class PhoneEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long phoneId;
    private  String number;
    private  String citycode;
    private  String contrycode;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public PhoneEntity(String number, String citycode, String contrycode) {
        this.number = number;
        this.citycode = citycode;
        this.contrycode = contrycode;
    }
}




