package co.edu.uco.asistenciauco.aplication.outport.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;




@Entity
@Table(name = "TipoIdentificacion")
public class TipoIdentificacionEntity {
	
	@Id
	@Column(name = "id")
	private UUID id;
	@Column(name = "clave")
	private String clave;
	@Column(name = "nombre")
	private String nombre;
	
	public UUID getId() {
		return id;
	}
	public void setId(final UUID id) {
		this.id = id;
	}
	
	public String getClave() {
		return clave;
	}
	public void setClave(final String clave) {
		// TODO: Cuidado con la limpieza de datos para evitar datos NULOS
		this.clave = clave;
	}

	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(final String nombre) {
		// TODO: Cuidado con la limpieza de datos para evitar datos NULOS
		this.nombre = nombre;
	}
	

	public TipoIdentificacionEntity() {
		setDefaultId();
		setDefaultNombre();
		setDefaultClave();
	}
	
	public TipoIdentificacionEntity(final UUID id) {
	    setId(id);
	    setDefaultClave();
	    setDefaultNombre();
	}
	
	public TipoIdentificacionEntity(final UUID id, final String clave, final String nombre) {
	    setId(id);
	    setClave(clave);
	    setNombre(nombre);
	}

	private void setDefaultId() {
		// TODO: Obtener valor por defecto
		// Lo más probable es que este valor esté en algún lugar o algún parámetro
		UUID defaultValue = UUID.randomUUID();
		setId(defaultValue);
	}
	
	public void setDefaultNombre() {
	    // TODO: Obtener valor por defecto
	    // Lo más probable es que este valor esté en algún lugar o algún parámetro
	    var defaultValue = "";
	    setNombre(defaultValue);
	}

	private void setDefaultClave() {
		// TODO: Obtener valor por defecto
		// Lo más probable es que este valor esté en algún lugar o algún parámetro
		var defaultValue = "";
		setClave(defaultValue);
	}
	
}