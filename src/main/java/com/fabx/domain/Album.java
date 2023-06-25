package com.fabx.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
public class Album {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "O nome não pode ser nulo!")
	@Size(min = 2, max = 50, message 
    = "O nome deve estar entre 2 e 50 caracteres")
	private String nome;

	@NotEmpty(message = "O nome não pode ser nulo!")
	@Size(min = 4, message="O campo ano precisa ter no mínimo 4 caracteres")
	private Integer ano;
	
	@ManyToMany
	@JoinTable(name="album_artista",
			joinColumns = @JoinColumn(name="album_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name="artista_id", referencedColumnName = "id"))
	private List<Artista> artista = new ArrayList<Artista>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Album other = (Album) obj;
		return Objects.equals(id, other.id);
	}

	public List<Artista> getArtista() {
		return artista;
	}

	public void setArtista(List<Artista> artista) {
		this.artista = artista;
	}
	
}
