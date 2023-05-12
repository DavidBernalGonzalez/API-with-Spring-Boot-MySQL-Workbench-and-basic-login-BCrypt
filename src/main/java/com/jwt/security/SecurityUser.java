package com.jwt.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.jwt.models.User;

import lombok.AllArgsConstructor;

@AllArgsConstructor // Añadimos el constructor de lombok
public class SecurityUser implements UserDetails {
	private static final long serialVersionUID = 5319264677005477013L;

	// Agregamos una propiedad de tipo user
	final private User user;

	@Override
	public String getUsername() {
		return user.getUsername();// Retornamos el username del objeto user
	}

	@Override
	public String getPassword() {
		return user.getPassword(); // Retornamos el password del objeto password
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		/*
		 * dentro del método getAuthorities() de la clase SecurityUser, vamos a retornar
		 * el listado de security Authorities obtenido del listado de Authoritys de la
		 * entidad users
		 */
		return user.getAuthorities().stream().map(SecurityAuthority::new).toList();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true; // Aunque no las vamos a usar las ponemos a true
	}

	@Override
	public boolean isAccountNonLocked() {
		return true; // Aunque no las vamos a usar las ponemos a true
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true; // Aunque no las vamos a usar las ponemos a true
	}

	@Override
	public boolean isEnabled() {
		return true; // Aunque no las vamos a usar las ponemos a true
	}

}
