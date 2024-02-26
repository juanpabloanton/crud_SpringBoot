package com.proyect.proyect.Controllers;

import java.util.List;
import java.util.Map;

import org.apache.catalina.connector.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyect.proyect.Models.Persona;
import com.proyect.proyect.Services.PersonaServices;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(path = "api/v1/alumno")
public class PersonaController {
    private final PersonaServices personaServices;
    private static final Logger logger = LoggerFactory.getLogger(PersonaController.class);

    @Autowired
    public PersonaController(PersonaServices personaServices) {
        this.personaServices = personaServices;
    }

    @GetMapping
    public ResponseEntity<List<Map<String, Object>>> obtenerPersonaMaterias() {
        List<Map<String, Object>> personas = personaServices.obtenerPersonaMaterias();
        return new ResponseEntity<>(personas, HttpStatus.OK);
    }

    @PostMapping("/store")
    public ResponseEntity<Object> store(@RequestBody Persona persona) {

        return this.personaServices.storepersona(persona);
    }

    @PutMapping("/update")
    public ResponseEntity<Object> update(@RequestBody Persona persona) {

        return this.personaServices.storepersona(persona);
    }

    @DeleteMapping(path = "delete/{id_persona}")
    public ResponseEntity<Object> eliminar(@PathVariable("id_persona") long id) {
        return this.personaServices.deletepersona(id);
    }

}
