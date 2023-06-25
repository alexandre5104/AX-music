package com.fabx.controller;

import java.util.List;

import com.fabx.domain.Album;
import com.fabx.domain.Artista;
import com.fabx.helper.MessageHelper;
import com.fabx.services.ServiceAlbum;
import com.fabx.services.ServiceArtista;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class ControllerAlbum {

	@Inject
	private MessageHelper mh;

	private Album album = new Album();
	
	private List<Artista> artistas;
	
	private Artista artista = new Artista();
	
	@Inject
	private ServiceAlbum serviceAlbum;
	
	@Inject
	private ServiceArtista serviceArtista;
	
	@PostConstruct
	public void init() {
		setArtistas(serviceArtista.getArtista());
	}

	public void salvar() {

		serviceAlbum.salvar(artista, album);;
		
		mh.addMensagem(new FacesMessage("Adicionado com sucesso"));

		setAlbum(new Album());
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

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

}
