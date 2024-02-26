package com.proyect.proyect.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;




@Entity
@Table(name = "persona_materia")
public class PersonaMateria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_persona_materia;
    @ManyToOne
    @JoinColumn(name = "id_persona")
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "id_materia")
    private Materia materia;


    

    public PersonaMateria() {
    }

    public PersonaMateria(Long id_persona_materia, Persona persona, Materia materia) {
        this.id_persona_materia = id_persona_materia;
        this.persona = persona;
        this.materia = materia;
    }

    public PersonaMateria(Persona persona, Materia materia) {
        this.persona = persona;
        this.materia = materia;
    }

    public Long getId_persona_materia() {
        return id_persona_materia;
    }

    public void setId_persona_materia(Long id_persona_materia) {
        this.id_persona_materia = id_persona_materia;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

}
