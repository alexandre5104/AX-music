package com.fabx.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Artista {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "O nome não pode ser nulo!")
	@Size(min = 3, max = 200, message 
    = "O nome deve estar entre 2 e 50 caracteres")
	private String nome;
	
	@NotEmpty(message = "A nacionalidade não pode ser nulo!")
	@Size(min = 10, max = 200, message 
    = "A nacionalidade deve estar entre 3 e 50 caracteres")
	private String nacionalidade;
	
}
