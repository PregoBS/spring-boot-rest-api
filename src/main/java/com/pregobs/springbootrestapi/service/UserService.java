package com.pregobs.springbootrestapi.service;

import com.pregobs.springbootrestapi.domain.model.User;

public interface UserService {
    User findById(Long id);

    User create(User userToCreate);
    
}
