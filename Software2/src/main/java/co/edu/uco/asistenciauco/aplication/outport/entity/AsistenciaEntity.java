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
@Table(name = "Asistencia")
public class AsistenciaEntity {

    @Id
    @Column(name = "id")
    private UUID id;

    @ManyToOne
    @Column(name = "estudianteGrupo_id")
    private EstudianteGrupoEntity estudianteGrupo;

    @ManyToOne
    @Column(name = "sesion")
    private SesionEntity sesion;

    @Column(name = "asistio")
    private boolean asistio;
    
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public EstudianteGrupoEntity getEstudianteGrupo() {
        return estudianteGrupo;
    }

    public void setEstudianteGrupo(EstudianteGrupoEntity estudianteGrupo) {
        this.estudianteGrupo = ObjectHelper.getDefault(estudianteGrupo, new EstudianteGrupoEntity());
    }

    public SesionEntity getSesion() {
        return sesion;
    }

    public void setSesion(SesionEntity sesion) {
        this.sesion = ObjectHelper.getDefault(sesion, new SesionEntity());
    }

    public boolean isAsistio() {
        return asistio;
    }

    public void setAsistio(boolean asistio) {
        this.asistio = asistio;
    }

    public AsistenciaEntity() {
        setDefaultId();
        setDefaultEstudianteGrupo();
        setDefaultSesion();
        setDefaultAsistio();
    }

    public AsistenciaEntity(final UUID id, final EstudianteGrupoEntity estudianteGrupo, final SesionEntity sesion, final boolean asistio) {
        setId(id);
        setEstudianteGrupo(estudianteGrupo);
        setSesion(sesion);
        setAsistio(asistio);
    }

    private void setDefaultId() {
        setId(UUIDHelper.generate());
    }

    private void setDefaultEstudianteGrupo() {
        setEstudianteGrupo(new EstudianteGrupoEntity());
    }

    private void setDefaultSesion() {
        setSesion(new SesionEntity());
    }

    private void setDefaultAsistio() {
        setAsistio(false);
    }
}
