package com.proyect.proyect.Models;

import org.springframework.context.annotation.Primary;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table

public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_persona;

    @Column(unique = true)
    private String nombre;

    private String direccion;

    private Integer edad;

    private String estado;

    public Persona(long id_persona, String nombre, String direccion, Integer edad, String estado) {
        this.id_persona = id_persona;
        this.nombre = nombre;
        this.direccion = direccion;
        this.edad = edad;
        this.estado = estado;
    }

    public Persona(String nombre, String direccion, Integer edad, String estado) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.edad = edad;
        this.estado = estado;
    }

    public Persona() {
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

}
