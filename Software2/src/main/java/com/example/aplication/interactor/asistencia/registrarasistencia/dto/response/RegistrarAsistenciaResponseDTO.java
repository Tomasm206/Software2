package com.example.aplication.interactor.asistencia.registrarasistencia.dto.response;

import java.util.List;

public class RegistrarAsistenciaResponseDTO {
	private boolean transaccionExitosa;
	private List<String> mensajes;
	
	public RegistrarAsistenciaResponseDTO() {
		super();
	}
	public boolean isTransaccionExitosa() {
		return transaccionExitosa;
	}
	public void setTransaccionExitosa(final boolean transaccionExitosa) {
		this.transaccionExitosa = transaccionExitosa;
	}
	public List<String> getMensajes() {
		return mensajes;
	}
	public void setMensajes(final List<String> mensajes) {
		this.mensajes = mensajes;
	}
	
	
}
