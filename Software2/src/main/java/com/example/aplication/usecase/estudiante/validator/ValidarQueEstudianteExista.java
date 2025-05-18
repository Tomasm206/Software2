package com.example.aplication.usecase.estudiante.validator;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.aplication.outport.repository.EstudianteRepository;
import com.example.aplication.usecase.validator.ValidationResultVO;
import com.example.aplication.usecase.validator.Validator;

@Service
public class ValidarQueEstudianteExista implements Validator<UUID, ValidationResultVO>{
	
	private EstudianteRepository estudianteRepository;

	public ValidarQueEstudianteExista(EstudianteRepository estudianteRepository) {
		this.estudianteRepository = estudianteRepository;
	}

	@Override
	public ValidationResultVO validate(UUID id) {
		// TODO Auto-generated method stub
		
		var resultadoValidacion = new ValidationResultVO();
		
		if (!estudianteRepository.existsById(id)) {
			//TODO: No se pueden quemar mensajes. Debe estar en el catalogo de mensajes
			resultadoValidacion.agregarMensaje("No existe un estudiante con el identificador " + id);
		}
		
		return resultadoValidacion;
	}
	
}
