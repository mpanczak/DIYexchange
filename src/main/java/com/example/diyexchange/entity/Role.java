package com.example.diyexchange.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "roles")
@Data
public class Role {

    @Id
    //@Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Column(name = "role_name", unique = true, nullable = false)
    private String name;

    @ManyToMany//(mappedBy = "roles")
    private List<User> users;
}