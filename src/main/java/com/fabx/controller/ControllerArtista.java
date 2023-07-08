package com.fabx.controller;

import java.util.List;

import com.fabx.domain.Artista;
import com.fabx.helper.MessageHelper;
import com.fabx.services.ServiceArtista;

import jakarta.annotation.PostConstruct;
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
	
	private List<Artista> artistas;
	
	@PostConstruct
	public void init(){
		artistas = serviceArtista.buscarTodos();
	}
	
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

	public List<Artista> getArtistas() {
		return artistas;
	}

	public void setArtistas(List<Artista> artistas) {
		this.artistas = artistas;
	}

}
