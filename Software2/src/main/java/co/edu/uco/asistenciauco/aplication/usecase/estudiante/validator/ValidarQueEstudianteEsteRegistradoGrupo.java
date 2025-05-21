package co.edu.uco.asistenciauco.aplication.usecase.estudiante.validator;

import java.util.UUID;

import co.edu.uco.asistenciauco.aplication.outport.repository.EstudianteGrupoRepository;
import co.edu.uco.asistenciauco.aplication.usecase.validator.ValidationResultVO;
import co.edu.uco.asistenciauco.aplication.usecase.validator.Validator;

public class ValidarQueEstudianteEsteRegistradoGrupo implements Validator<UUID, ValidationResultVO> {
	
	private EstudianteGrupoRepository estudianteGrupoRepository;
	
	public ValidarQueEstudianteEsteRegistradoGrupo(EstudianteGrupoRepository estudianteGrupoRepository) {
		this.estudianteGrupoRepository = estudianteGrupoRepository;
	}
	
	@Override
	public ValidationResultVO validate(UUID id) {
		var resultadoValidacion = new ValidationResultVO();
		
		if (!estudianteGrupoRepository.existsById(id)) {
			resultadoValidacion.agregarMensaje("El estudiante no está registrado en el grupo.");
		}
		
		return resultadoValidacion;
	}

}
