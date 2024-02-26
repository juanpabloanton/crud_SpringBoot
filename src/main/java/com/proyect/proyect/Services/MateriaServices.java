package com.proyect.proyect.Services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.proyect.proyect.Interface.MateriaInterface;

@Service
public class MateriaServices {
    private final MateriaInterface materiainterface;

    public MateriaServices(MateriaInterface materiainterface) {
        this.materiainterface = materiainterface;
    }

    public List<Map<String, Object>> obtenerMaterias() {
        List<Map<String, Object>> materias = new ArrayList<>();
        List<Map<String, Object>> results = materiainterface.getComboMaterias();

        for (Map<String, Object> result : results) {
            Map<String, Object> materia = new HashMap<>();
            materia.put("label", result.get("label"));
            materia.put("value", result.get("value"));
            materias.add(materia);
        }

        return materias;
    }

}
