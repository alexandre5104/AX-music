package com.fabx.controller;

import java.time.LocalTime;

import com.fabx.domain.Musica;
import com.fabx.helper.MessageHelper;

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

	public void salvar() {

		System.out.println(musica.getNome());

		System.out.println(musica.getDuracao());

		mh.addMensagem(new FacesMessage("Adicionado com sucesso"));

		musica = new Musica();
	}

	public Musica getMusica() {
		return musica;
	}

	public void setMusica(Musica musica) {
		this.musica = musica;
	}

}
