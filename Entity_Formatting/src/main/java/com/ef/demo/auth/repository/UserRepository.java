package com.ef.demo.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ef.demo.model.User;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
