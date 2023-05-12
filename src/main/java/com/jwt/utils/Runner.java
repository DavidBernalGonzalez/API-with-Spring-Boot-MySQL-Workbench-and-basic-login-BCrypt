package com.jwt.utils;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.jwt.models.Authority;
import com.jwt.models.User;
import com.jwt.repositories.AuthorityRepository;
import com.jwt.repositories.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Component // Para que se ejecute la clase cuando se arranqueu la aplicación
@Slf4j // Lombok log para poder escribir comentarios de forma más sencilla
public class Runner implements CommandLineRunner {
	// Inyectamos ambas dependencias en la clase Runner
	private final UserRepository userRepository;
	private final AuthorityRepository authorityRepository;

	public Runner(UserRepository userRepository, AuthorityRepository authorityRepository) {
		this.userRepository = userRepository;
		this.authorityRepository = authorityRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		// Si no existen authorities creamos las siguientes
		if (this.authorityRepository.count() == 0) {
			this.authorityRepository.saveAll(List.of(new Authority(AuthorityName.ADMIN), // Creamos la
																							// AuthorityName.ADMIN
					new Authority(AuthorityName.READ), // Creamos la AuthorityName.READ
					new Authority(AuthorityName.WRITE) // Creamos la AuthorityName.WRITE
			));
			log.info("Authorities values was added!");
		}

		// Si no existen usuarios creamos los siguientes
		if (this.userRepository.count() == 0) {
			// Creamos los usuarios:
			// User: david, Pass: 1234, Authority: READ
			this.userRepository.save(new User("david", new BCryptPasswordEncoder().encode("1234"),
					(List<Authority>) List.of(this.authorityRepository.findByName(AuthorityName.READ).get())));
			// User: bernal, Pass: 1234, Authority: WRITE
			this.userRepository.save(new User("bernal", new BCryptPasswordEncoder().encode("1234"),
					(List<Authority>) List.of(this.authorityRepository.findByName(AuthorityName.WRITE).get())));
			// User: gonzalez, Pass: 1234, Authority: ADMIN
			this.userRepository.save(new User("gonzalez", new BCryptPasswordEncoder().encode("1234"),
					(List<Authority>) List.of(this.authorityRepository.findByName(AuthorityName.ADMIN).get())));
			log.info("Users & relational tabled (N:M) values was added!");
		}
	}
}
