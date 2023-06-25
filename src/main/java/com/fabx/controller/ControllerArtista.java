package com.fabx.controller;

import com.fabx.domain.Artista;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class ControllerArtista {

	private Artista artista = new Artista();

	public void salvar() {
		
		System.out.println(artista.getNome());
		
		artista = new Artista();
	}
	
	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}
	
}
