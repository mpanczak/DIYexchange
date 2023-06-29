package com.example.diyexchange.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "pictures")
@Data
@RequiredArgsConstructor
public class Picture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

//    private String type;

    @Lob
    @Column(columnDefinition = "BLOB")
//    private byte[] data;
    private byte[] imageData;

    @ManyToOne
    private Post post;

}
