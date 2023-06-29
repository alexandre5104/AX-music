package com.fabx.services;

import java.util.List;

import com.fabx.domain.Album;
import com.fabx.domain.Artista;
import com.fabx.repository.RepositoryAlbum;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

public class ServiceAlbum {

	@Inject
	private RepositoryAlbum repositoryAlbum;
	
	@Transactional
	public void salvar(Artista artista, Album album) {
		repositoryAlbum.salvar(artista, album);
	}
	
	public List<Album> buscarTodos(){
		return repositoryAlbum.buscarTodos();
	}
	
}
