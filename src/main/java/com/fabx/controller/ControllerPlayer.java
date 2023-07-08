package com.fabx.controller;

import java.io.Serializable;
import java.util.List;

import org.primefaces.component.audio.AudioType;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.fabx.domain.Musica;
import com.fabx.services.ServiceMusica;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@SessionScoped
public class ControllerPlayer implements Serializable {

	private static final long serialVersionUID = 1L;

	private StreamedContent musica;
	
	private List<Musica> musicas;
	
	private String nomeMusica = "initial";
	
	@Inject
	private ServiceMusica serviceMusica;
	
	public void play(String musica)  {
		
		this.nomeMusica = musica;
		
		setMusica(DefaultStreamedContent.builder()
				.contentType(AudioType.MP3.getMediaType())
				.stream(() -> 
					FacesContext
					.getCurrentInstance()
					.getExternalContext()
					.getResourceAsStream("/resources/music/"+musica+".mp3")
				).build());
	}
	
	@PostConstruct
	public void init() {
		setMusicas(serviceMusica.buscarTodos());
	}

	public StreamedContent getMusica() {
		return musica;
	}

	public void setMusica(StreamedContent musica) {
		this.musica = musica;
	}

	public List<Musica> getMusicas() {
		return musicas;
	}

	public void setMusicas(List<Musica> musicas) {
		this.musicas = musicas;
	}

	public String getNomeMusica() {
		return nomeMusica;
	}

	public void setNomeMusica(String nomeMusica) {
		this.nomeMusica = nomeMusica;
	}


}
