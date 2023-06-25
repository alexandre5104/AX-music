package com.fabx.converter;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

@FacesConverter(value = "converterTime")
public class ConverterTime implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		LocalTime time = LocalTime.parse(value);
		return time;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		
		DateTimeFormatter formater = DateTimeFormatter.ofPattern("mm:ss");
		
		LocalTime localTime = (LocalTime) value;
		
		String horaFormatada = localTime.format(formater);
		
		return horaFormatada;
	}

}
