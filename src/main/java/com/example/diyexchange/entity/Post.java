package com.example.diyexchange.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

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

    private String title;

    @OneToMany(mappedBy = "post")
    private List<Picture> pictures;

    @ManyToMany
    private Set<User> likedByUsers;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments;
}
