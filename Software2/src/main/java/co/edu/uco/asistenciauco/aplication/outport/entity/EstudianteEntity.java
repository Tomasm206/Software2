package co.edu.uco.asistenciauco.aplication.outport.entity;

import java.util.UUID;

import co.edu.uco.asistenciauco.crosscutting.helpers.TextHelper;
import co.edu.uco.asistenciauco.crosscutting.helpers.UUIDHelper;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;




@Entity
@Table(name = "Estudiante")
public class EstudianteEntity {
	
	@Id
	@Column(name = "id")
	private UUID id;
	@ManyToOne
	@JoinColumn(name = "tipoIdentificacion")
	private TipoIdentificacionEntity tipoIdentificacion;
	@Column(name = "numeroIdentificacion")
	private String numeroIdentificacion;
	@Column(name = "nombresCompletos")
	private String nombresCompletos;

	public UUID getId() {
		return id;
	}
	public void setId(final UUID id) {
		this.id = id;
	}
	

	public TipoIdentificacionEntity getTipoIdentificacion() {
		return tipoIdentificacion;
	}
	public void setTipoIdentificacion(TipoIdentificacionEntity tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}
	public String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}
	public void setNumeroIdentificacion(String numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}
	public String getNombresCompletos() {
		return nombresCompletos;
	}
	public void setNombresCompletos(String nombresCompletos) {
		this.nombresCompletos = nombresCompletos;
	}
	
	public EstudianteEntity(final UUID id, final TipoIdentificacionEntity tipoIdentificacion, final String numeroIdentificacion,
			final String nombresCompletos) {
		setId(id);
		setTipoIdentificacion(tipoIdentificacion);
		setNumeroIdentificacion(numeroIdentificacion);
		setNombresCompletos(nombresCompletos);
	}
	
	public EstudianteEntity() {
        setDefaultId();
        setNumeroIdentificacion("");
        setNombresCompletos("");
        setTipoIdentificacion(new TipoIdentificacionEntity());
    }
	
	 public EstudianteEntity(final UUID id) {
	        setId(id);
	}

	 private void setDefaultId() {
		 // TODO: Obtener valor por defecto
		 // Lo más probable es que este valor esté en algún lugar o algún parámetro
		 UUID defaultValue = UUIDHelper.generate();
		 setId(defaultValue);
	 }

	public void setDefaultNombre() {
	    // TODO: Obtener valor por defecto
	    // Lo más probable es que este valor esté en algún lugar o algún parámetro
	    var defaultValue = TextHelper.getDefault("");
	}

}