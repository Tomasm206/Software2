package com.example.aplication.outport.repository;

import com.example.aplication.outport.entity.TipoIdentificacionEntity;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoIdentificacionRepository extends JpaRepository<TipoIdentificacionEntity, UUID> {


}
