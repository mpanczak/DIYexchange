package com.example.diyexchange.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "elements")
@Data
public class Element {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Post post;

    private String name;

    private String model;

    private Long amount;
}
