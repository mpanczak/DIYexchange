package com.example.diyexchange.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "follows")
public class Follow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User follower;

    @OneToMany
    private List<User> watchlist;
}
