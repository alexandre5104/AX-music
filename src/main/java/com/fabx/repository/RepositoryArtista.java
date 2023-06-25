package com.fabx.repository;

import com.fabx.domain.Artista;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

public class RepositoryArtista {

	@PersistenceContext
	private EntityManager manager;
	
	public void salvar(Artista artista) {
		manager.persist(artista);
	}
}
