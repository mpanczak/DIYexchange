package com.example.diyexchange.repository;

import com.example.diyexchange.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByLogin(String login);
    Optional<User> findByEmail(String login);

    @Query(value = "select email from users where id IN " +
            "(select follower_id from user_follows join users u on u.id = user_follows.followed_id where followed_id = ?1)",
            nativeQuery = true)
    List<String> findFollowersEmails(Long id);

    @Query(value = "select login from users where id IN " +
            "(select follower_id from user_follows join users u on u.id = user_follows.followed_id where followed_id = ?1)",
            nativeQuery = true)
    List<String> findFollowers(Long id);

    @Query(value = "select login from users where id IN" +
            " (select followed_id from user_follows join users u on u.id = user_follows.followed_id where follower_id = ?1)",
            nativeQuery = true)
    List<String> findFollows(Long id);

    @Modifying
    @Query(value = "INSERT INTO user_follows (followed_id, follower_id) VALUES (?, ?)", nativeQuery = true)
    void addFollow (Long authorId, Long followerId);

    @Query(value = "SELECT COUNT(followed_id) FROM user_follows WHERE followed_id=? AND follower_id=?", nativeQuery = true)
    Integer selectUniqueFollow(Long authorId, Long followerId);
}
