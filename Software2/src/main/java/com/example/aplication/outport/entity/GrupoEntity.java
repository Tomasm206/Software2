package com.example.aplication.outport.entity;

import java.util.UUID;

import com.example.crosscutting.helpers.ObjectHelper;
import com.example.crosscutting.helpers.UUIDHelper;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Grupo")
public class GrupoEntity {

    @Id
    @Column(name = "id")
    private UUID id;

    @ManyToOne
    @Column(name = "profesor_id")
    private ProfesorEntity profesor;

    @ManyToOne
    @Column(name = "materia_id")
    private MateriaEntity materia;

    @Column(name = "cantidadEstudiantes")
    private int cantidadEstudiantes;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ProfesorEntity getProfesor() {
        return profesor;
    }

    public void setProfesor(ProfesorEntity profesor) {
        this.profesor = ObjectHelper.getDefault(profesor, new ProfesorEntity());
    }

    public MateriaEntity getMateria() {
        return materia;
    }

    public void setMateria(MateriaEntity materia) {
        this.materia = ObjectHelper.getDefault(materia, new MateriaEntity());
    }

    public int getCantidadEstudiantes() {
        return cantidadEstudiantes;
    }

    public void setCantidadEstudiantes(int cantidadEstudiantes) {
        this.cantidadEstudiantes = cantidadEstudiantes;
    }

    public GrupoEntity() {
        setDefaultId();
        setDefaultProfesor();
        setDefaultMateria();
        setDefaultCantidadEstudiantes();
    }

    public GrupoEntity(UUID id, ProfesorEntity profesor, MateriaEntity materia, int cantidadEstudiantes) {
        setId(id);
        setProfesor(profesor);
        setMateria(materia);
        setCantidadEstudiantes(cantidadEstudiantes);
    }

    private void setDefaultId() {
        setId(UUIDHelper.generate());
    }

    private void setDefaultProfesor() {
        setProfesor(new ProfesorEntity());
    }

    private void setDefaultMateria() {
        setMateria(new MateriaEntity());
    }

    private void setDefaultCantidadEstudiantes() {
        setCantidadEstudiantes(0);
    }
}
