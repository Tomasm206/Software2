package com.example.aplication.interactor.asistencia.registrarasistencia.impl;

import org.springframework.stereotype.Service;

import com.example.aplication.interactor.asistencia.registrarasistencia.RegistrarAsistenciaInteractor;
import com.example.aplication.interactor.asistencia.registrarasistencia.dto.request.RegistrarAsistenciaRequestDTO;
import com.example.aplication.interactor.asistencia.registrarasistencia.dto.response.RegistrarAsistenciaResponseDTO;
import com.example.aplication.usecase.asistencia.registrarasistencia.domain.Asistencia;

@Service
public class RegistrarAsistenciaInteractorImpl implements RegistrarAsistenciaInteractor{

	@Override
	public RegistrarAsistenciaResponseDTO ejecutar(final RegistrarAsistenciaRequestDTO dto) {
		
		Asistencia asistencia = null; //Obtener asistencia con un mapper desde el DTO
		
		//Llamar al caso de uso
		
		
		// TODO Auto-generated method stub
		return null;
	}

}
