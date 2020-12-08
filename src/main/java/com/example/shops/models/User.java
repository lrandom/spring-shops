package com.example.shops.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String email;

    @Column(name = "fullname")
    private String fullName;

    private String password;

    private String address;

    private String phone;

    private int level;
}
