package com.proyect.proyect.Services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.proyect.proyect.Interface.PersonaInterface;
import com.proyect.proyect.Models.Persona;
import com.proyect.proyect.Models.PersonaMateria;

@Service
public class PersonaServices {
    HashMap<String, Object> datos = new HashMap<>();
    private final PersonaInterface personainterface;

    public PersonaServices(PersonaInterface personainterface) {
        this.personainterface = personainterface;
    }

    public List<Persona> getnombres() {
        return this.personainterface.findAll();/* List.of(new Persona(1, "juan", "cristobal colon entre", 15, "A")); */
    }

    public List<Object[]> getPersonaMaterias() {
        return this.personainterface.getPersonaMaterias();
    }

      public List<Map<String, Object>> obtenerPersonaMaterias() {
        List<Object[]> results = personainterface.getPersonaMaterias();
        List<Map<String, Object>> personas = new ArrayList<>();

        for (Object[] result : results) {
            Map<String, Object> persona = new HashMap<>();
            persona.put("id", result[0]);
            persona.put("nombre", result[1]);
            persona.put("materiasAsignadas", result[2]);
            persona.put("edad", result[3]);
            persona.put("direccion", result[4]);
            personas.add(persona);
        }

        return personas;
    }

    public ResponseEntity<Object> storepersona(Persona persona) {
        Optional<Persona> res = personainterface.findPersonaBynombre(persona.getNombre());
        datos = new HashMap<>();

        if (res.isPresent() && persona.getId_persona() == 0) {
            datos.put("error", true);
            datos.put("Message", "Ya existe el nombre en la base de datos");
            // throw new IllegalStateException("ya existe la persona");
            return new ResponseEntity<>(datos, HttpStatus.CONFLICT);
        }
        datos.put("Message", "creado con exito");
        if (persona.getId_persona() != 0) {
            datos.put("Message", "Se actualizo con exito");
        }
        personainterface.save(persona);
        datos.put("data", persona);
        return new ResponseEntity<>(
                datos,
                HttpStatus.CREATED);
    }

    public ResponseEntity<Object> deletepersona(Long id) {
        boolean existe = this.personainterface.existsById(id);
        datos = new HashMap<>();
        if (!existe) {
            datos.put("error", true);
            datos.put("Message", "No existe el producto con ese id");
            return new ResponseEntity<>(datos, HttpStatus.CONFLICT);
        }
        datos.put("Message", "eliminado con exito");
        personainterface.deleteById(id);

        return new ResponseEntity<>(datos, HttpStatus.CREATED);
    }

}
