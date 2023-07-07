package com.example.diyexchange.service;

import com.example.diyexchange.entity.User;
import com.example.diyexchange.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addFollow(Long authorId, Long followerId) {
        userRepository.addFollow(authorId, followerId);
    }
    public User retrieveLoggedUser() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String username = userDetails.getUsername();

            Optional<User> user = userRepository.findByLogin(username);
            return user.get();
//        }
//        return null;
    }

    public List<String> fetchFollowerLogins(Long id) {
        return userRepository.findFollowers(id);
    }

    public List<String> fetchFollowLogins(Long id) {
        return userRepository.findFollows(id);
    }

    public List<String> fetchEmails(Long id) {
        return userRepository.findFollowersEmails(id);
    }

}
