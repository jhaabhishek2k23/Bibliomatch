package com.backend.bibliomatch.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.bibliomatch.entities.User;



public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}