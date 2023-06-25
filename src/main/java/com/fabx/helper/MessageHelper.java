package com.fabx.helper;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;

public class MessageHelper {

	@Inject
	private FacesContext context;
	
	public void addMensagem(FacesMessage message) {
		context.addMessage(null, message);
	}
}
