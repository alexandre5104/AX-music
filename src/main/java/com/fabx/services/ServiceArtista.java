package com.fabx.services;

import java.io.Serializable;
import java.util.List;

import com.fabx.domain.Artista;
import com.fabx.repository.RepositoryArtista;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

public class ServiceArtista implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private RepositoryArtista repositoryArtista;
	
	@Transactional
	public void salvar(Artista artista) {
		repositoryArtista.salvar(artista);
	}
	
	public List<Artista> buscarTodos(){
		return repositoryArtista.buscarTodos();
	}
	
}
