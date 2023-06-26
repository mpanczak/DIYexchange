package com.example.diyexchange.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User author;

    private String content;

    @ManyToMany
    private List<Picture> pictures;

    @OneToMany
    private List<Reaction> reactions;

    @OneToMany
    private List<Comment> comments;
}
