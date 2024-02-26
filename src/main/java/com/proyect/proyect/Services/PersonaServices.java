package com.proyect.proyect.Services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.apache.catalina.connector.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.proyect.proyect.Controllers.MateriaController;
import com.proyect.proyect.Interface.MateriaInterface;
import com.proyect.proyect.Interface.PersonaInterface;
import com.proyect.proyect.Interface.PersonaMateriaInterface;
import com.proyect.proyect.Models.Materia;
import com.proyect.proyect.Models.Persona;
import com.proyect.proyect.Models.PersonaMateria;
import com.proyect.proyect.ModelsRequest.PersonaRequest;

@Service
public class PersonaServices {
    HashMap<String, Object> datos = new HashMap<>();
    private final PersonaInterface personainterface;
    private final PersonaMateriaInterface personamateriainterface;
    private static final Logger logger = LoggerFactory.getLogger(PersonaServices.class);


    public PersonaServices(PersonaInterface personainterface, PersonaMateriaInterface personamateriainterface) {
        this.personainterface = personainterface;
        this.personamateriainterface = personamateriainterface;
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
            persona.put("matricula", result[5]);
            persona.put("telefono", result[6]);
            personas.add(persona);
        }

        return personas;
    }

    public ResponseEntity<Object> storePersonaConMaterias(PersonaRequest personaRequest) {

        Persona persona = new Persona();
        persona.setDireccion(personaRequest.getDireccion());
        persona.setNombre(personaRequest.getNombre());
        persona.setMatricula(personaRequest.getMatricula());
        persona.setEdad(personaRequest.getEdad());
        persona.setTelefono(personaRequest.getTelefono());
        Optional<Persona> res = personainterface.findPersonaBynombre(persona.getNombre());
        datos = new HashMap<>();

        logger.info("Mensaje de información");
        logger.info(persona.toString());

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
        datos.put("persona", persona);

        Set<PersonaMateria> personaMaterias = new HashSet<>();
        for (Long idMateria : personaRequest.getId_materia()) {
            Materia materia = new Materia();
            materia.setId_materia(idMateria);
            PersonaMateria personaMateria = new PersonaMateria(persona, materia);
            personaMaterias.add(personaMateria);
        }
        
        personamateriainterface.saveAll(personaMaterias);
        datos.put("persona_materia", personaMaterias);

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
