package com.example.diyexchange.repository;

import com.example.diyexchange.entity.Post;
import com.example.diyexchange.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findPostsByUser(User user);

    @Query(value = "SELECT * FROM posts ORDER BY timestamp LIMIT ?,?;", nativeQuery = true)
    List<Post> findNewstPostsPagined (Integer offset, Integer limit);

    Integer countPostByIdNotNull();
}
