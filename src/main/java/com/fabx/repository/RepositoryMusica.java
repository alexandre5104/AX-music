package com.fabx.repository;

import java.util.List;

import com.fabx.domain.Album;
import com.fabx.domain.Artista;
import com.fabx.domain.Musica;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class RepositoryMusica {

	@PersistenceContext
	private EntityManager manager;
	
	public void salvar(Artista artista, Musica musica, Album album) {
		Artista artistaRetornado = manager.find(Artista.class, artista.getId());
		Album albumRetornado = manager.find(Album.class, album.getId());
		musica.getArtista().add(artistaRetornado);
		musica.getAlbuns().add(albumRetornado);
		manager.persist(musica);
	}
	
	public List<Musica> buscarTodos(){
		return manager.createQuery("SELECT m FROM Musica m", Musica.class).getResultList();
	}
	
}
