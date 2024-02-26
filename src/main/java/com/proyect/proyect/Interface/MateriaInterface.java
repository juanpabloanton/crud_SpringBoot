package com.proyect.proyect.Interface;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.proyect.proyect.Models.Materia;

@Repository
public interface MateriaInterface extends JpaRepository<Materia, Long> {
    
}
