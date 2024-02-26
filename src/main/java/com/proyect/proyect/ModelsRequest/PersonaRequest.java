package com.proyect.proyect.ModelsRequest;

public class PersonaRequest {
    private String direccion;
    private String nombre;
    private String matricula;
    private Integer edad;
    private String telefono;
    private Long[] id_materia;

    public PersonaRequest(String direccion, String nombre, String matricula, Integer edad, String telefono,
            Long[] id_materia) {
        this.direccion = direccion;
        this.nombre = nombre;
        this.matricula = matricula;
        this.edad = edad;
        this.telefono = telefono;
        this.id_materia = id_materia;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Long[] getId_materia() {
        return id_materia;
    }

    public void setId_materia(Long[] id_materia) {
        this.id_materia = id_materia;
    }

}
