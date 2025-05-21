package co.edu.uco.asistenciauco.aplication.outport.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.uco.asistenciauco.aplication.outport.entity.SesionEntity;

@Repository
public interface SesionRepository extends JpaRepository<SesionEntity, UUID> {
	// Aquí puedes agregar métodos personalizados si es necesario
	// Por ejemplo, para buscar sesiones por fecha, usuario, etc.

}
	// Este repositorio extiende JpaRepository, lo que proporciona métodos CRUD básicos