package com.itechf.backend.security;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity, Integer> {
    // Since email is unique, we'll find users by email
    Optional<UserEntity> findByEmail(String email);
}
