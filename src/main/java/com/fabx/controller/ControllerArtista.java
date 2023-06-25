package com.fabx.controller;

import java.time.LocalDateTime;
import java.time.LocalTime;

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
	
	private LocalTime duracao;

	private Artista artista = new Artista();

	public void salvar() {
		
		System.out.println(artista.getNome());
		
		System.out.println(duracao);
		
		mh.addMensagem(new FacesMessage("Adicionado com sucesso"));
		
		artista = new Artista();
	}
	
	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}
	
	public LocalTime getDuracao() {
		return duracao;
	}

	public void setDuracao(LocalTime duracao) {
		this.duracao = duracao;
	}
}
