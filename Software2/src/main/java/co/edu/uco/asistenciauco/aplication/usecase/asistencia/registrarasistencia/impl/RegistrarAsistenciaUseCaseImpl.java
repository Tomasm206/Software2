package co.edu.uco.asistenciauco.aplication.usecase.asistencia.registrarasistencia.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import co.edu.uco.asistenciauco.aplication.usecase.asistencia.registrarasistencia.RegistraarAsistenciaUseCase;
import co.edu.uco.asistenciauco.aplication.usecase.asistencia.registrarasistencia.domain.Asistencia;
import co.edu.uco.asistenciauco.aplication.usecase.asistencia.registrarasistencia.domain.Estudiante;
import co.edu.uco.asistenciauco.aplication.usecase.asistencia.registrarasistencia.domain.RegistrarAsistenciaResponseVO;
import co.edu.uco.asistenciauco.aplication.usecase.asistencia.validator.ValidarQueExisteAsistenciaPorSesion;
import co.edu.uco.asistenciauco.aplication.usecase.estudiante.validator.ValidarQueEstudianteEsteRegistradoGrupo;
import co.edu.uco.asistenciauco.aplication.usecase.estudiante.validator.ValidarQueEstudianteExista;
import co.edu.uco.asistenciauco.aplication.usecase.sesion.validator.ValidarQueSesionExista;

@Service
public class RegistrarAsistenciaUseCaseImpl implements RegistraarAsistenciaUseCase{
	

    private ValidarQueEstudianteExista estudianteExiste;
    private ValidarQueSesionExista sesionExiste;
    private RegistrarAsistenciaResponseVO resultado;
    private ValidarQueEstudianteEsteRegistradoGrupo estudianteGrupoValidador;
    private ValidarQueExisteAsistenciaPorSesion existeAsistenciaPorSesion;

    public RegistrarAsistenciaUseCaseImpl(ValidarQueEstudianteExista estudianteExiste,
                                          ValidarQueSesionExista sesionExiste,
                                          ValidarQueEstudianteEsteRegistradoGrupo estudianteGrupoValidador,
                                          ValidarQueExisteAsistenciaPorSesion existeAsistenciaPorSesion) {
        this.estudianteExiste = estudianteExiste;
        this.sesionExiste = sesionExiste;
        this.estudianteGrupoValidador = estudianteGrupoValidador;
        this.existeAsistenciaPorSesion = existeAsistenciaPorSesion;
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
		    resultado.agregarMensajes(existeAsistenciaPorSesion.validate(dominio.getSesion().getId()).getMensajes());
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
	        	validarQueEstudianteEsteRegistradoGrupo(estudiante.getId());
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
	
	private void validarQueEstudianteEsteRegistradoGrupo(UUID idEstudiante) {
		resultado.agregarMensajes(estudianteGrupoValidador.validate(idEstudiante).getMensajes());
	}

	private void registrarAsistenciaEstudiante(Estudiante estudiante) {
	    // 1. Registrar asistencia
		
		// 2. Enviar la notificación de correo al estudiante porque no asistió
	    if (!estudiante.isAsistio()) {
	        // Enviar la notificación de correo al estudiante porque no asistió
	    }
	}

}
