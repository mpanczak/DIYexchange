package com.example.diyexchange.repository;

import com.example.diyexchange.entity.Post;
import com.example.diyexchange.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
