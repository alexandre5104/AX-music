package com.fabx.converter;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

@FacesConverter(value = "converterTime")
public class ConverterTime implements Converter<LocalTime> {

	@Override
	public LocalTime getAsObject(FacesContext context, UIComponent component, String value) {
		LocalTime time = LocalTime.parse(value);
		return time;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, LocalTime value) {
		
		DateTimeFormatter formater = DateTimeFormatter.ofPattern("mm:ss");
		
		LocalTime localTime = value;
		
		String horaFormatada = localTime.format(formater);
		
		return horaFormatada;
	}

}
