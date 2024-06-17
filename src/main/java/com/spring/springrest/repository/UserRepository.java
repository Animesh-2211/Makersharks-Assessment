package com.spring.springrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.springrest.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    // You can define custom query methods here if needed
}
