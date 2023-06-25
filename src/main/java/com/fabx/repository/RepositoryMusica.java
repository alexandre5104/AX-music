package com.fabx.repository;

import com.fabx.domain.Artista;
import com.fabx.domain.Musica;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class RepositoryMusica {

	@PersistenceContext
	private EntityManager manager;
	
	public void salvar(Artista artista, Musica musica) {
		Artista artistaRetornado = manager.find(Artista.class, artista.getId());
		musica.getArtista().add(artistaRetornado);
		manager.persist(musica);
	}
	
}
