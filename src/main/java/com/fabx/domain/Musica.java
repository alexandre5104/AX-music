package com.fabx.domain;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Musica {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "O nome não pode ser nulo!")
	@Size(min = 3, max = 50, message 
    = "O nome deve estar entre 2 e 50 caracteres")
	private String nome;

	private LocalTime duracao;
	
	@ManyToMany
	@JoinTable(name="musica_artista",
			joinColumns = @JoinColumn(name="musica_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name="artista_id", referencedColumnName = "id"))
	private List<Artista> artistas = new ArrayList<Artista>();
	
	@ManyToMany
	@JoinTable(name="musica_albun",
			joinColumns = @JoinColumn(name="musica_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name="album_id", referencedColumnName = "id"))
	private List<Album> albuns = new ArrayList<Album>();
	
}
