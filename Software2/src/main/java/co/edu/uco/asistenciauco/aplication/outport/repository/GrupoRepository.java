package co.edu.uco.asistenciauco.aplication.outport.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.uco.asistenciauco.aplication.outport.entity.GrupoEntity;

public interface GrupoRepository extends JpaRepository<GrupoEntity, UUID> {
	// Este repositorio se encarga de la persistencia de los datos de los grupos
	// y su relación con la asistencia.
	// Se pueden agregar métodos personalizados si es necesario.
}