package com.example.aplication.usecase.sesion.validator;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.aplication.outport.repository.EstudianteRepository;
import com.example.aplication.outport.repository.SesionRepository;
import com.example.aplication.usecase.validator.ValidationResultVO;
import com.example.aplication.usecase.validator.Validator;

@Service
public class ValidarQueSesionExista implements Validator<UUID, ValidationResultVO>{
	
	private SesionRepository sesionRepository;

	public ValidarQueSesionExista(SesionRepository sesionRepository) {
		this.sesionRepository = sesionRepository;
	}

	@Override
	public ValidationResultVO validate(UUID id) {
		
		var resultadoValidacion = new ValidationResultVO();
		
		if (!sesionRepository.existsById(id)) {
			//TODO: No se pueden quemar mensajes. Debe estar en el catalogo de mensajes
			resultadoValidacion.agregarMensaje("No existe un sesión con el identificador " + id);
		}
		
		return resultadoValidacion;
	}
	
}
