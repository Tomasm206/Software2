package co.edu.uco.asistenciauco.aplication.outport.entity;

import java.util.UUID;

import co.edu.uco.asistenciauco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.asistenciauco.crosscutting.helpers.UUIDHelper;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "EstudianteGrupo")
public class EstudianteGrupoEntity {

    @Id
    @Column(name = "id")
    private UUID id;

    @ManyToOne
    @Column(name = "grupo_id")
    private GrupoEntity grupo;

    @ManyToOne
    @Column(name = "estudiante_id")
    private EstudianteEntity estudiante;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public GrupoEntity getGrupo() {
        return grupo;
    }

    public void setGrupo(GrupoEntity grupo) {
        this.grupo = ObjectHelper.getDefault(grupo, new GrupoEntity());
    }

    public EstudianteEntity getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(EstudianteEntity estudiante) {
        this.estudiante = ObjectHelper.getDefault(estudiante, new EstudianteEntity());
    }

    public EstudianteGrupoEntity() {
        setDefaultId();
        setDefaultGrupo();
        setDefaultEstudiante();
    }

    public EstudianteGrupoEntity(UUID id, GrupoEntity grupo, EstudianteEntity estudiante) {
        setId(id);
        setGrupo(grupo);
        setEstudiante(estudiante);
    }

    private void setDefaultId() {
        setId(UUIDHelper.generate());
    }

    private void setDefaultGrupo() {
        setGrupo(new GrupoEntity());
    }

    private void setDefaultEstudiante() {
        setEstudiante(new EstudianteEntity());
    }
}
