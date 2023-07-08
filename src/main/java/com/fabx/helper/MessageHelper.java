package com.fabx.helper;

import java.io.Serializable;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;

public class MessageHelper implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private FacesContext context;
	
	public void addMensagem(FacesMessage message) {
		context.addMessage(null, message);
	}
}
