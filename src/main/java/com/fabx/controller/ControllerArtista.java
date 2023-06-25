package com.fabx.controller;

import com.fabx.domain.Artista;
import com.fabx.helper.MessageHelper;
import com.fabx.services.ServiceArtista;

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

	@Inject
	private ServiceArtista serviceArtista;
	
	public void salvar() {
		
		serviceArtista.salvar(artista);
		
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
