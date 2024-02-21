package com.proyect.proyect.Interface;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyect.proyect.Models.Persona;

@Repository
public interface PersonaInterface extends JpaRepository<Persona, Long> {

    Optional<Persona> findPersonaBynombre(String nombre);
}
