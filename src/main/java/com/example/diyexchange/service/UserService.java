package com.example.diyexchange.service;

import com.example.diyexchange.entity.User;
import com.example.diyexchange.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User retrieveLoggedUser() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        Optional<User> user = userRepository.findById(Long.valueOf(authentication.getName()));
        return userRepository.findById(1L).get(); //TODO user is hardcoded now
    }

    public List<String> fetchEmails(Long id) {
        return userRepository.findFollowersEmails(id);
    }

}
