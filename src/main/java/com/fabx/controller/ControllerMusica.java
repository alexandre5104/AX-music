package com.fabx.controller;

import java.util.List;

import com.fabx.domain.Artista;
import com.fabx.domain.Musica;
import com.fabx.helper.MessageHelper;
import com.fabx.services.ServiceArtista;
import com.fabx.services.ServiceMusica;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class ControllerMusica {

	@Inject
	private MessageHelper mh;

	private Musica musica = new Musica();
	
	private List<Artista> artistas;
	
	private Artista artista = new Artista();
	
	@Inject
	private ServiceMusica ServiceMusica;
	
	@Inject
	private ServiceArtista serviceArtista;
	
	@PostConstruct
	public void init() {
		setArtistas(serviceArtista.getArtista());
	}

	public void salvar() {

		ServiceMusica.salvar(artista, musica);
		
		mh.addMensagem(new FacesMessage("Adicionado com sucesso"));

		musica = new Musica();
	}

	public Musica getMusica() {
		return musica;
	}

	public void setMusica(Musica musica) {
		this.musica = musica;
	}

	public List<Artista> getArtistas() {
		return artistas;
	}

	public void setArtistas(List<Artista> artistas) {
		this.artistas = artistas;
	}

	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}

}
