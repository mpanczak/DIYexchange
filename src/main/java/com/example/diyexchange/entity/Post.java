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

    @Lob
    @Column(columnDefinition = "TEXT")
    private String content;

    @ManyToMany
    private List<Picture> pictures;

    @OneToMany(mappedBy = "post")
    private List<Reaction> reactions;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments;
}
