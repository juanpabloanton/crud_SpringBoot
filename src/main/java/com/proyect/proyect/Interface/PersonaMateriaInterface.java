package com.proyect.proyect.Interface;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyect.proyect.Models.Materia;
import com.proyect.proyect.Models.PersonaMateria;

@Repository
public interface PersonaMateriaInterface extends JpaRepository<PersonaMateria, Long> {
    
}
