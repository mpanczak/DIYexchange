package com.example.diyexchange.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "follows")
public class Follow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", unique = true)
//    private User follower;
    private User user;

    @ManyToMany
    @JoinColumn(name = "user_id")
//    private List<User> watchlist;
    private List<User> users;
}
