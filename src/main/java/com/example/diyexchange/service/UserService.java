package com.example.diyexchange.service;

import com.example.diyexchange.entity.User;
import com.example.diyexchange.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User retrieveLoggedUser() {
        return userRepository.findById(1L).get(); //TODO user is hardcoded now
    }
}
