package com.proyect.proyect.Models;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Primary;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "persona")

public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_persona;

    @Column(unique = true)
    private String nombre;

    private String direccion;

    private String matricula;
    private String telefono;

    private Integer edad;

    private String estado;

    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
    private Set<PersonaMateria> personaMaterias = new HashSet<>();

    public Persona() {
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id_persona=" + id_persona +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", matricula='" + matricula + '\'' +
                ", edad='" + edad + '\'' +
                '}';
    }

    public Persona(long id_persona, String nombre, String direccion, String matricula, String telefono, Integer edad,
            String estado, Set<PersonaMateria> personaMaterias) {
        this.id_persona = id_persona;
        this.nombre = nombre;
        this.direccion = direccion;
        this.matricula = matricula;
        this.telefono = telefono;
        this.edad = edad;
        this.estado = estado;
        this.personaMaterias = personaMaterias;
    }

    public Persona(String nombre, String direccion, String matricula, String telefono, Integer edad, String estado,
            Set<PersonaMateria> personaMaterias) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.matricula = matricula;
        this.telefono = telefono;
        this.edad = edad;
        this.estado = estado;
        this.personaMaterias = personaMaterias;
    }

    public long getId_persona() {
        return id_persona;
    }

    public void setId_persona(long id_persona) {
        this.id_persona = id_persona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Set<PersonaMateria> getPersonaMaterias() {
        return personaMaterias;
    }

    public void setPersonaMaterias(Set<PersonaMateria> personaMaterias) {
        this.personaMaterias = personaMaterias;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}
