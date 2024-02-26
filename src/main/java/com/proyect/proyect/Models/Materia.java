package com.proyect.proyect.Models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import org.springframework.context.annotation.Primary;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "materia")
public class Materia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_materia;
    private String descripcion;

    @OneToMany(mappedBy = "materia", cascade = CascadeType.ALL)
    private Set<PersonaMateria> personaMaterias = new HashSet<>();

    public Materia() {
    }

    public Materia(String descripcion, Set<PersonaMateria> personaMaterias) {
        this.descripcion = descripcion;
        this.personaMaterias = personaMaterias;
    }

    public Materia(Long id_materia, String descripcion, Set<PersonaMateria> personaMaterias) {
        this.id_materia = id_materia;
        this.descripcion = descripcion;
        this.personaMaterias = personaMaterias;
    }

    public Long getId_materia() {
        return id_materia;
    }

    public void setId_materia(Long id_materia) {
        this.id_materia = id_materia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<PersonaMateria> getPersonaMaterias() {
        return personaMaterias;
    }

    public void setPersonaMaterias(Set<PersonaMateria> personaMaterias) {
        this.personaMaterias = personaMaterias;
    }

}
