package com.fabx.services;

import java.util.List;

import com.fabx.domain.Album;
import com.fabx.domain.Artista;
import com.fabx.domain.Musica;
import com.fabx.repository.RepositoryMusica;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

public class ServiceMusica {

	@Inject
	private RepositoryMusica repositoryMusica;
	
	@Transactional
	public void salvar(Artista artista, Musica musica, Album album) {
		repositoryMusica.salvar(artista, musica, album);
	}
	
	public List<Musica> buscarTodos(){
		return repositoryMusica.buscarTodos();
	}
	
}
