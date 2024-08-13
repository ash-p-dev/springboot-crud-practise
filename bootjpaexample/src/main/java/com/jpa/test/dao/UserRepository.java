package com.jpa.test.dao;

import com.jpa.test.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    // JpaRepository provides methods for CRUD operations
}
