package com.pregobs.springbootrestapi.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pregobs.springbootrestapi.domain.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
