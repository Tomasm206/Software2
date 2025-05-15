package com.example.aplication.outport.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import com.example.crosscutting.helpers.ObjectHelper;
import com.example.crosscutting.helpers.UUIDHelper;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Sesion")
public class SesionEntity {

    @Id
    @Column(name = "id")
    private UUID id;

    @ManyToOne
    @Column(name = "grupo_id")
    private GrupoEntity grupo;

    @Column(name = "fechaHora")
    private LocalDateTime fechaHora;

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

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora != null ? fechaHora : LocalDateTime.now();
    }

    public SesionEntity() {
        setDefaultId();
        setDefaultGrupo();
        setDefaultFechaHora();
    }

    public SesionEntity(UUID id, GrupoEntity grupo, LocalDateTime fechaHora) {
        setId(id);
        setGrupo(grupo);
        setFechaHora(fechaHora);
    }

    private void setDefaultId() {
        setId(UUIDHelper.generate());
    }

    private void setDefaultGrupo() {
        setGrupo(new GrupoEntity());
    }

    private void setDefaultFechaHora() {
        setFechaHora(LocalDateTime.now());
    }
}
