package com.fabx.services;

import com.fabx.domain.Artista;
import com.fabx.domain.Musica;
import com.fabx.repository.RepositoryMusica;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

public class ServiceMusica {

	@Inject
	private RepositoryMusica repositoryMusica;
	
	@Transactional
	public void salvar(Artista artista, Musica musica) {
		repositoryMusica.salvar(artista, musica);
	}
	
}
