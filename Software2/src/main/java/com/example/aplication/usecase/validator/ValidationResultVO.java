package com.example.aplication.usecase.validator;

import java.util.ArrayList;
import java.util.List;

public class ValidationResultVO {

	private List<String> mensajes;
	
	public ValidationResultVO() {
		setMensajes(new ArrayList<>());
		//Validacion correcta va a ser variable virtual.
	}

	public List<String> getMensajes() {
		return mensajes;
	}

	private void setMensajes(List<String> mensajes) {
		//TODO: Asegurar que los datos no sean nulos y en caso que no sean crear el valor por defecto
		this.mensajes = mensajes;
	}

	public void agregarMensajes(List<String> mensajes) {
        setMensajes(mensajes);
    }

    public void agregarMensaje(String mensaje) {
        // TODO: Asegurar que no esté nulo o vacío
        getMensajes().add(mensaje);
    }

    public boolean isValidacionCorrecta() {
        return getMensajes().isEmpty();
    }
	
    
}