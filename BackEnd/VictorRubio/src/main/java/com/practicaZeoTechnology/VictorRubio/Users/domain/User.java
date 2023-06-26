package com.practicaZeoTechnology.VictorRubio.Users.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private int age;
    private String email;
    private String password;


    public User( String name, int age, String email, String password) {

        this.name = name;
        this.age = age;
        this.email = email;
        this.password = password;
    }
}
