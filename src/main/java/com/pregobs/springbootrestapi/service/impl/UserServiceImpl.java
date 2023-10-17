package com.pregobs.springbootrestapi.service.impl;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.pregobs.springbootrestapi.domain.model.User;
import com.pregobs.springbootrestapi.domain.repository.UserRepository;
import com.pregobs.springbootrestapi.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User userToCreate) {
        if (userToCreate.getId() != null && userRepository.existsById(userToCreate.getId())) {
            throw new IllegalArgumentException("This User ID already exists");
        }
        if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
            throw new IllegalArgumentException("This Account Number already exists");
        }
        return userRepository.save(userToCreate);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }
}
