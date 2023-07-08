package com.fabx.controller;

import java.io.Serializable;
import java.util.List;

import com.fabx.domain.Album;
import com.fabx.domain.Artista;
import com.fabx.helper.MessageHelper;
import com.fabx.services.ServiceAlbum;
import com.fabx.services.ServiceArtista;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class ControllerAlbum implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Inject
	private MessageHelper mh;

	private Album album = new Album();
	
	private List<Album> albuns;
	
	private List<Artista> artistas;
	
	private Artista artista = new Artista();
	
	@Inject
	private ServiceAlbum serviceAlbum;
	
	@Inject
	private ServiceArtista serviceArtista;
	
	@PostConstruct
	public void init() {
		artistas = serviceArtista.buscarTodos();	
		setAlbuns(serviceAlbum.buscarTodos());
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

	public List<Album> getAlbuns() {
		return albuns;
	}

	public void setAlbuns(List<Album> albuns) {
		this.albuns = albuns;
	}

}
