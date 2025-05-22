package co.edu.uco.asistenciauco.infreaestructure.primaryadapters.api.rest.asistencia;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.asistenciauco.aplication.interactor.asistencia.registrarasistencia.RegistrarAsistenciaInteractor;
import co.edu.uco.asistenciauco.aplication.interactor.asistencia.registrarasistencia.dto.request.RegistrarAsistenciaRequestDTO;

@RestController
@RequestMapping("/api/v1/asistencias")
public class AsistenciaController {
	
	private RegistrarAsistenciaInteractor registrarAsistenciaInteractor;
	
	public AsistenciaController(RegistrarAsistenciaInteractor registrarAsistenciaInteractor) {
		this.registrarAsistenciaInteractor = registrarAsistenciaInteractor;
	}
	
	@PostMapping("/registrar")
	public String registrarAsistencia(@RequestBody RegistrarAsistenciaRequestDTO dto) {
		// Aquí iría la lógica para registrar la asistencia
		// Por ejemplo, llamar a un servicio que maneje la lógica de negocio
		registrarAsistenciaInteractor.ejecutar(dto);
		return "Asistencia registrada con éxito";
	}
	
	@GetMapping("/listar")
	public String listarAsistencias() {
		// Aquí iría la lógica para listar las asistencias
		// Por ejemplo, llamar a un servicio que maneje la lógica de negocio
		return "Listando asistencias";
	}

}
