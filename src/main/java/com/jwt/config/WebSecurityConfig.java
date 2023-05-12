package com.jwt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfig {
	/*
	 * Se utiliza como administrador de credenciales del usuario para posteriormente
	 * trabajar con spring security nos permite obtener los detalles de un usuario,
	 * como su nombre de usuario, contraseña y roles, y proporcionarlos a Spring
	 * Security para que pueda llevar a cabo la autenticación y autorización
	 * correctamente. Esta interfaz es parte fundamental del proceso de
	 * autenticación en Spring Security.
	 */
//	@Bean
//	public UserDetailsService userDetailsServiceImpl() {
//		UserDetails userDetails = User.withUsername("davidbernal").password("1234").roles("read").build();
//		// Es una de las implementaciones que nos ofrece UserDetailsService
//		return new InMemoryUserDetailsManager(userDetails);
//	}

	/*
	 * Spring Security necesita además saber quién maneja las contraseñas. Para
	 * ello, vamos a crear un @Bean/método llamado passwordEncoder() que retornará
	 * un PasswordEncoder y por el momento para nuestro ejemplo vamos a utilizar el
	 * NoOpPasswordEncoder que pese a no estar recomendado para producción ya que
	 * las contraseñas estarán en texto plano. Nos va a permitir entender como
	 * funciona esto y más adelante cambiaremos el encoder del password por un que
	 * si que realice el cifrado de la password.
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
