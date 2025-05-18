package com.example.aplication.outport.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.aplication.outport.entity.AsistenciaEntity;

@Repository
public interface AsistenciaRepository extends JpaRepository<AsistenciaEntity, UUID>{

}
