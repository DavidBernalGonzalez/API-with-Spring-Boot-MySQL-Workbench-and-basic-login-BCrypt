package com.jwt.models;

import com.jwt.utils.AuthorityName;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "authorities")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Authority {
	// Propiedades del objectos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	private AuthorityName name;

	/*
	 * Constructor que solamente contiene el campo name con la finalidad 
	 * que el id se auto asigne automáticamente sin la necesidad de 
	 * que nosotros tengamos que definirlo o pongamos el campo a null
	 */
	public Authority(AuthorityName name) {
		this.name = name;
	}
}

