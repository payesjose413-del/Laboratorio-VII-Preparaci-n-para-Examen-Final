package com.ejercicio.profesores.controller;

import com.ejercicio.profesores.dto.CrearProfesorRequest;
import com.ejercicio.profesores.model.Profesor;
import com.ejercicio.profesores.service.ProfesorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/profesores")
public class ProfesorController {

    private final ProfesorService profesorService;

    public ProfesorController(ProfesorService profesorService) {
        this.profesorService = profesorService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Profesor crear(@Valid @RequestBody CrearProfesorRequest request) {
        return profesorService.crear(request);
    }

    @GetMapping
    public List<Profesor> listar(@RequestParam(required = false) String especialidad) {
        return profesorService.listar(especialidad);
    }

    @GetMapping("/{id}")
    public Profesor obtenerPorId(@PathVariable Long id) {
        return profesorService.obtenerPorId(id);
    }
}
