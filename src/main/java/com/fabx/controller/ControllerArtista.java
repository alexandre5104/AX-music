package com.fabx.controller;

import com.fabx.domain.Artista;
import com.fabx.helper.MessageHelper;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class ControllerArtista {
	
	@Inject
	private MessageHelper mh;

	private Artista artista = new Artista();

	public void salvar() {
		
		System.out.println(artista.getNome());
		
		mh.addMensagem(new FacesMessage("Adicionado com sucesso"));
		
		artista = new Artista();
	}
	
	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}
}
