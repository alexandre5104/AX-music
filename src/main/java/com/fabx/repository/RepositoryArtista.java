package com.fabx.repository;

import java.io.Serializable;
import java.util.List;

import com.fabx.domain.Artista;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class RepositoryArtista implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
	private EntityManager manager;
	
	public void salvar(Artista artista) {
		manager.persist(artista);
	}
	
	public Artista buscarPorId(Long id) {
		
		Artista artista = manager.find(Artista.class, id);
		
		System.out.println(artista.getNome());
		
		return artista;
	}
	
	public List<Artista> buscarTodos(){
		return manager.createQuery("select a from Artista a", Artista.class).getResultList();
	}
}
