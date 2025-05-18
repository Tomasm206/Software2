package co.edu.uco.asistenciauco.aplication.usecase.asistencia.registrarasistencia.domain;

import java.util.UUID;

public final class Sesion {
	
	private UUID id;
	
	public Sesion(final UUID id, final boolean asistio) {
		setId(id);
	}

	public UUID getId() {
		return id;
	}

	private void setId(final UUID id) {
		this.id = id;
	}
}
