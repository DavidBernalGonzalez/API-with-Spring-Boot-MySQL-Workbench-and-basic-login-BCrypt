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
	 * como su nombre de usuario, contrase�a y roles, y proporcionarlos a Spring
	 * Security para que pueda llevar a cabo la autenticaci�n y autorizaci�n
	 * correctamente. Esta interfaz es parte fundamental del proceso de
	 * autenticaci�n en Spring Security.
	 */
//	@Bean
//	public UserDetailsService userDetailsServiceImpl() {
//		UserDetails userDetails = User.withUsername("davidbernal").password("1234").roles("read").build();
//		// Es una de las implementaciones que nos ofrece UserDetailsService
//		return new InMemoryUserDetailsManager(userDetails);
//	}

	/*
	 * Spring Security necesita adem�s saber qui�n maneja las contrase�as. Para
	 * ello, vamos a crear un @Bean/m�todo llamado passwordEncoder() que retornar�
	 * un PasswordEncoder y por el momento para nuestro ejemplo vamos a utilizar el
	 * NoOpPasswordEncoder que pese a no estar recomendado para producci�n ya que
	 * las contrase�as estar�n en texto plano. Nos va a permitir entender como
	 * funciona esto y m�s adelante cambiaremos el encoder del password por un que
	 * si que realice el cifrado de la password.
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
