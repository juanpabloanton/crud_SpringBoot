package com.proyect.proyect.Controllers;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyect.proyect.Services.MateriaServices;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping(path = "api/v1/materia")
public class MateriaController {
    private final MateriaServices materiaServices;
    private static final Logger logger = LoggerFactory.getLogger(MateriaController.class);

    @Autowired
    public MateriaController(MateriaServices materiaServices) {
        this.materiaServices = materiaServices;
    }

    @GetMapping
    public ResponseEntity<List<Map<String, Object>>> obtenerMaterias() {
        List<Map<String, Object>> materias = materiaServices.obtenerMaterias();
        return new ResponseEntity<>(materias, HttpStatus.OK);
    }
}
