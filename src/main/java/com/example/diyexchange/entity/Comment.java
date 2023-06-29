package com.example.diyexchange.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Table(name = "comments")
@Data
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Post post;

    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp timestamp;
}
