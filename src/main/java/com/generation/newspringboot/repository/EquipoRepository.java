package com.generation.newspringboot.repository;

import com.generation.newspringboot.model.Equipo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EquipoRepository extends JpaRepository <Equipo, Integer>{
    @Query(value = "SELECT nombre_proyecto FROM equipos WHERE equipo_id = ?1", nativeQuery = true)
    List <Equipo> findProyectoById(Integer id);
    
}
