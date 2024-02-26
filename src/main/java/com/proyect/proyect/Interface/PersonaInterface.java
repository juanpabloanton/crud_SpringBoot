package com.proyect.proyect.Interface;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.proyect.proyect.Models.Persona;

@Repository
public interface PersonaInterface extends JpaRepository<Persona, Long> {

    Optional<Persona> findPersonaBynombre(String nombre);

    @Query("SELECT persona.id_persona, " +
            "persona.nombre AS nombre_persona, " +
            "STRING_AGG(materia.descripcion, ', ') AS materias_asignadas, " +
            "persona.edad, " +
            "persona.direccion, " +
            "persona.matricula, " +
            "persona.telefono " +
            "FROM Persona persona " +
            "INNER JOIN persona.personaMaterias pm " +
            "INNER JOIN pm.materia materia " +
            "GROUP BY persona.id_persona, persona.nombre, persona.edad, persona.direccion " +
            "ORDER BY persona.id_persona ASC")
    List<Object[]> getPersonaMaterias();

}
