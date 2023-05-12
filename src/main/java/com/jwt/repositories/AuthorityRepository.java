package com.jwt.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jwt.models.Authority;
import com.jwt.utils.AuthorityName;

public interface AuthorityRepository extends JpaRepository<Authority, Long>{
	// Creamos un método que nos retonará una autoridad por su nombre
	Optional<Authority> findByName(AuthorityName name);
}
