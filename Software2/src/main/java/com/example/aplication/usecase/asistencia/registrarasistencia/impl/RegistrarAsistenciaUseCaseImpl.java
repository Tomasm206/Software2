package com.example.aplication.usecase.asistencia.registrarasistencia.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.aplication.outport.repository.AsistenciaRepository;
import com.example.aplication.usecase.asistencia.registrarasistencia.RegistraarAsistenciaUseCase;
import com.example.aplication.usecase.asistencia.registrarasistencia.domain.Asistencia;
import com.example.aplication.usecase.asistencia.registrarasistencia.domain.Estudiante;
import com.example.aplication.usecase.asistencia.registrarasistencia.domain.RegistrarAsistenciaResponseVO;
import com.example.aplication.usecase.estudiante.validator.ValidarQueEstudianteExista;
import com.example.aplication.usecase.sesion.validator.ValidarQueSesionExista;

@Service
public class RegistrarAsistenciaUseCaseImpl implements RegistraarAsistenciaUseCase{
	

    private ValidarQueEstudianteExista estudianteExiste;
    private ValidarQueSesionExista sesionExiste;
    private AsistenciaRepository asistenciaRepository;
    private RegistrarAsistenciaResponseVO resultado;

    public RegistrarAsistenciaUseCaseImpl(AsistenciaRepository asistenciaRepository,
                                          ValidarQueEstudianteExista estudianteExiste,
                                          ValidarQueSesionExista sesionExiste) {
        this.asistenciaRepository = asistenciaRepository;
        this.estudianteExiste = estudianteExiste;
        this.sesionExiste = sesionExiste;
        resultado = new RegistrarAsistenciaResponseVO();
    }
	
	@Override
	public RegistrarAsistenciaResponseVO ejecutar(Asistencia dominio) {
		
		// 1. Validar integridad del objeto a nivel de tipo de datos, longitud, 
		// obligatoriedad, formato, rango...


		// 2. La sesión debe existir
		if (resultado.isValidacionCorrecta()) {
			// Validar que la sesión existe
			resultado.agregarMensajes(sesionExiste.validate(dominio.getSesion().getId()).getMensajes());
		}

		// 3. El profesor que registra la asistencia debe existir
		if (resultado.isValidacionCorrecta()) {
					
		}


		// 4. El grupo debe estar activo
		if (resultado.isValidacionCorrecta()) {
			
		}


		// 5. El profesor debe estar asignado al grupo

		if (resultado.isValidacionCorrecta()) {
			
		}

		// 6. No se puede tener una asistencia ya registrada para la sesion
		if (resultado.isValidacionCorrecta()) {
			
		}


		// 7: La asistencia se debe registrar entre los plazos establecidos
				
		if (resultado.isValidacionCorrecta()) {
			
		}

		// 8. Validar que el estudiantes sean consistentes para el registro de asistencia.
		if (resultado.isValidacionCorrecta()) {
			registrarAsistenciaEstudiantes(dominio.getEstudiantes());
		}

		
		// 9. Retornar resultado
		return resultado;
	}
	
	private void registrarAsistenciaEstudiantes(List<Estudiante> estudiantes) {
	    for (Estudiante estudiante : estudiantes) {
	        var registrarAsistenciaResponseEstudianteVO = new RegistrarAsistenciaResponseVO();

	        // 1. Validar que el estudiante exista
	        validarQueEstudianteExiste(estudiante.getId());

	        // 2. Validar que el estudiante esté registrado en un grupo
	        if (registrarAsistenciaResponseEstudianteVO.isValidacionCorrecta()) {
	        	
	        }

	        // 3. Validar que el estudiante no tenga la materia cancelada por alguna novedad
	        if (registrarAsistenciaResponseEstudianteVO.isValidacionCorrecta()) {
	        	
	        }

	        // 4. Registrar asistencias por cada estudiante.
	        if (registrarAsistenciaResponseEstudianteVO.isValidacionCorrecta()) {
	        	registrarAsistenciaEstudiante(estudiante);
	        }

	        // 5. Agregar los mensajes de respuesta al objeto de respuesta principal
	        resultado.agregarMensajes(registrarAsistenciaResponseEstudianteVO.getMensajes());
	    }
	}

	
	private void validarQueEstudianteExiste(UUID idEstudiante) {
		
		resultado.agregarMensajes(estudianteExiste.validate(idEstudiante).getMensajes());
	}

	private void registrarAsistenciaEstudiante(Estudiante estudiante) {
	    // 1. Registrar asistencia
		
		// 2. Enviar la notificación de correo al estudiante porque no asistió
	    if (!estudiante.isAsistio()) {
	        // Enviar la notificación de correo al estudiante porque no asistió
	    }
	}

}
