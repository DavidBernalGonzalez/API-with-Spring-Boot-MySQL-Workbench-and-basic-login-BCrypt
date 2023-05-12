package com.jwt.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jwt.models.User;
import com.jwt.repositories.UserRepository;
import com.jwt.security.SecurityUser;

/* 
 * Añadimos la anotación @Service para indicarle a Spring que se trata 
 * de una clase que se trata de una clase que se utiliza como 
 * un componente de servicio.
 */
@Service
public class SecurityUserDetailsService implements UserDetailsService {
	// Definimos un atributo de tipo userRepository en el que inyectaremos la
	// instancia del userRepository desde el constructor
	private final UserRepository userRepository;

	// Inyectamos una instancia de userRepository dentro del constructor de la clase
	public SecurityUserDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	// Este método se ha autogenerado al implementar de UserDetailsService
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// Obtenemos el usuario mediante al método findByUserName
		Optional<User> optUser = this.userRepository.findByUsername(username);

		// Si existe retornamos un user creado a partir del usuario
		if (optUser.isPresent()) {
			return new SecurityUser(optUser.get());
		}
		// En el caso de que no existe el usuario, lanzamos una excepción de tipo
		// UsernameNotFoundExcelption
		throw new UsernameNotFoundException("User not found: " + username);
	}

}