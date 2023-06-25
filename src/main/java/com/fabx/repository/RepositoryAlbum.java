package com.fabx.repository;

import com.fabx.domain.Album;
import com.fabx.domain.Artista;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class RepositoryAlbum {

	@PersistenceContext
	private EntityManager manager;
	
	public void salvar(Artista artista, Album album) {
		Artista artistaRetornado = manager.find(Artista.class, artista.getId());
		album.getArtista().add(artistaRetornado);
		manager.persist(album);
	}
	
}
