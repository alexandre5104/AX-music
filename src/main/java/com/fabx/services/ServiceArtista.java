package com.fabx.services;

import com.fabx.domain.Artista;
import com.fabx.repository.RepositoryArtista;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

public class ServiceArtista {

	@Inject
	private RepositoryArtista repositoryArtista;
	
	@Transactional
	public void salvar(Artista artista) {
		repositoryArtista.salvar(artista);
	}
	
}
