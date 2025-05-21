package co.edu.uco.asistenciauco.aplication.interactor.asistencia.registrarasistencia.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.asistenciauco.aplication.interactor.asistencia.registrarasistencia.RegistrarAsistenciaInteractor;
import co.edu.uco.asistenciauco.aplication.interactor.asistencia.registrarasistencia.dto.request.RegistrarAsistenciaRequestDTO;
import co.edu.uco.asistenciauco.aplication.interactor.asistencia.registrarasistencia.dto.response.RegistrarAsistenciaResponseDTO;
import co.edu.uco.asistenciauco.aplication.usecase.asistencia.registrarasistencia.RegistraarAsistenciaUseCase;
import co.edu.uco.asistenciauco.aplication.usecase.asistencia.registrarasistencia.domain.Asistencia;
import jakarta.transaction.Transactional;

@Service
public class RegistrarAsistenciaInteractorImpl implements RegistrarAsistenciaInteractor{
	
	private RegistraarAsistenciaUseCase registraarAsistenciaUseCase;
	
	public RegistrarAsistenciaInteractorImpl(RegistraarAsistenciaUseCase registrarAsistenciaUseCase) {
		this.registraarAsistenciaUseCase = registrarAsistenciaUseCase;
	}
	
	@Override
	@Transactional //DAOFactory
	public RegistrarAsistenciaResponseDTO ejecutar(final RegistrarAsistenciaRequestDTO dto) {
		
		Asistencia asistencia = null; //Obtener asistencia con un mapper desde el DTO
		
		//Llamar al caso de uso
		var resultadoVO = registraarAsistenciaUseCase.ejecutar(asistencia);
		
		RegistrarAsistenciaResponseDTO responseDTO = null; //Obtener response DTO a partir de el Response VO que retorna el caso de uso.
		
		// TODO Auto-generated method stub
		return responseDTO;
	}
	// Asegurar y garatizar los mappers, que envie de un lado a otro.
}
