package com.fabx.controller;

import java.io.FileInputStream;

import org.primefaces.component.audio.AudioType;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import jakarta.inject.Named;

@Named
public class ControllerMusic {

	private StreamedContent musica;

	public ControllerMusic() {

		setMusica(DefaultStreamedContent.builder()
				.contentType(AudioType.MP3.getMediaType())
				.stream(() -> {
					try {
						return new 
							FileInputStream("C:\\Users\\abati\\Music\\musicas estudos\\Dylan Sitts  Visitors.mp3");
					} catch (Exception e) {
						e.printStackTrace();
						return null;
					}
				}).build());

	}

	public StreamedContent getMusica() {
		return musica;
	}

	public void setMusica(StreamedContent musica) {
		this.musica = musica;
	}

}
