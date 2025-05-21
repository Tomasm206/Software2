package co.edu.uco.asistenciauco.aplication.usecase.asistencia.validator;

import java.util.UUID;

import co.edu.uco.asistenciauco.aplication.outport.repository.AsistenciaRepository;
import co.edu.uco.asistenciauco.aplication.usecase.validator.ValidationResultVO;
import co.edu.uco.asistenciauco.aplication.usecase.validator.Validator;

/**
 * Validador que verifica si ya existe una asistencia registrada
 * para una sesión dada por su identificador (UUID).
 */
public class ValidarQueExisteAsistenciaPorSesion implements Validator<UUID, ValidationResultVO> {
	
	private final AsistenciaRepository asistenciaRepository;

	public ValidarQueExisteAsistenciaPorSesion(AsistenciaRepository asistenciaRepository) {
		this.asistenciaRepository = asistenciaRepository;
	}
	
	@Override
	public ValidationResultVO validate(UUID idSesion) {
		ValidationResultVO resultadoValidacion = new ValidationResultVO();

		if (idSesion == null) {
			resultadoValidacion.agregarMensaje("El identificador de la sesión no puede ser nulo.");
			return resultadoValidacion;
		}
		
		if (asistenciaRepository.existsById(idSesion)) {
			resultadoValidacion.agregarMensaje("Ya existe una asistencia registrada para esta sesión.");
		}
		
		return resultadoValidacion;
	}
}
