package com.example.diyexchange.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String login;

    private String email;

    private String password;

    @OneToMany(mappedBy = "user")
    private List<Post> posts;

    @OneToMany(mappedBy = "user")
    private List<Comment> comments;

    @ManyToMany(mappedBy = "likedByUsers")
    private List<Post> likedPosts;

//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "user_role",
//            joinColumns = {@JoinColumn(name = "user_id")},
//            inverseJoinColumns = {@JoinColumn(name = "role_id")})
//    private Set<Role> roles;
    @ManyToMany(mappedBy = "users")
    private List<Role> roles;

    @ManyToMany
    @JoinTable(name = "user_follows",
            joinColumns = @JoinColumn(name = "follower_id"),
            inverseJoinColumns = @JoinColumn(name = "followed_id"))

    private Set<User> follows;

    @ManyToMany(mappedBy = "follows")
    private Set<User> followers;


    public Set<User> getFollows() {
        if (follows == null) {
            follows = new HashSet<>();
        }
        return follows;
    }

    public Set<User> getFollowers() {
        if (followers == null) {
            followers = new HashSet<>();
        }
        return followers;
    }
}
