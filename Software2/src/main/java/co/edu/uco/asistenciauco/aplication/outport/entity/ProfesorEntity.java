package co.edu.uco.asistenciauco.aplication.outport.entity;

import java.util.UUID;

import co.edu.uco.asistenciauco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.asistenciauco.crosscutting.helpers.TextHelper;
import co.edu.uco.asistenciauco.crosscutting.helpers.UUIDHelper;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Profesor")
public class ProfesorEntity {

	@Id
	@Column(name = "id")
	private UUID id;
	
	@ManyToOne
    @Column(name = "tipoIdentificacion_id")
    private TipoIdentificacionEntity tipoIdentificacion;
	
	@Column(name = "numeroIdentificacion")
	private String numeroIdentificacion;
	
	@Column(name = "nombresCompletos")
    private String nombresCompletos;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
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

	public TipoIdentificacionEntity getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	public void setTipoIdentificacion(TipoIdentificacionEntity tipoIdentificacion) {
		this.tipoIdentificacion = ObjectHelper.getDefault(tipoIdentificacion, new TipoIdentificacionEntity());
	}

	public ProfesorEntity() {
		setDefaultId();
        setDefaultTipoIdentificacion();
        setDefaultNumeroIdentificacion();
        setDefaultNombresCompletos();
	}

	public ProfesorEntity(UUID id, String numeroIdentificacion, String nombresCompletos) {
		setId(id);
        setTipoIdentificacion(tipoIdentificacion);
        setNumeroIdentificacion(numeroIdentificacion);
        setNombresCompletos(nombresCompletos);
	}
	
	private void setDefaultId() {
		UUID defaultValue = UUIDHelper.generate();
		setId(defaultValue);
    }

    private void setDefaultTipoIdentificacion() {
    	//TODO: Realizar objetos
    	TipoIdentificacionEntity tipoIdentificacionEntity = new TipoIdentificacionEntity();
        setTipoIdentificacion(tipoIdentificacionEntity);
    }

    private void setDefaultNumeroIdentificacion() {
        setNumeroIdentificacion(TextHelper.getDefault(numeroIdentificacion));
    }

    private void setDefaultNombresCompletos() {
        setNombresCompletos(TextHelper.getDefault(nombresCompletos));
    }
}
