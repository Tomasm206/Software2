package com.example.aplication.usecase.asistencia.registrarasistencia.domain;

import java.util.UUID;

public final class Profesor {
	
	private UUID id;
	
	public Profesor(final UUID id, final boolean asistio) {
		setId(id);
	}

	public UUID getId() {
		return id;
	}

	private void setId(final UUID id) {
		this.id = id;
	}
}
