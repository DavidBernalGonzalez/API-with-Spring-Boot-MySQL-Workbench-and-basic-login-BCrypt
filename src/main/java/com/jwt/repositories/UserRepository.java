package com.jwt.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jwt.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
	// Vamos a definir un método que busque si existe un usuario por su nombre de
	// usuario
	Optional<User> findByUsername(String username);
}
