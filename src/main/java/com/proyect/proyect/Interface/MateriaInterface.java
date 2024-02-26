package com.proyect.proyect.Interface;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.proyect.proyect.Models.Materia;

@Repository
public interface MateriaInterface extends JpaRepository<Materia, Long> {
    @Query("select new map(m.id_materia as value, m.descripcion as label) from Materia m")
    List<Map<String, Object>> getComboMaterias();
}
