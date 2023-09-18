package com.example.ecommerceapi.repositories;

import com.example.ecommerceapi.model.entites.UserSchema;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthRepo extends JpaRepository<UserSchema,Integer> {
    Optional<UserSchema> findByEmail(String email);
}
