package com.example.diyexchange.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "pictures")
@Data
public class Picture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String type;

    @Lob
    @Column(columnDefinition = "BLOB")
    private byte[] data;
}
