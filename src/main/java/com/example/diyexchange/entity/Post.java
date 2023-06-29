package com.example.diyexchange.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "posts")
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
//    @JoinColumn(name = "user_id")
    private User user;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String content;

    @OneToMany(mappedBy = "post")
    private List<Picture> pictures;

    @ManyToMany
    private List<User> likedByUsers;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments;
}
