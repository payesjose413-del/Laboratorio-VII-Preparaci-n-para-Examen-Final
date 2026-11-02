package com.ejercicio.profesores.service;

import com.ejercicio.profesores.dto.CrearProfesorRequest;
import com.ejercicio.profesores.exception.RecursoNoEncontradoException;
import com.ejercicio.profesores.model.Profesor;
import com.ejercicio.profesores.repository.ProfesorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesorService {

    private final ProfesorRepository profesorRepository;

    public ProfesorService(ProfesorRepository profesorRepository) {
        this.profesorRepository = profesorRepository;
    }

    public Profesor crear(CrearProfesorRequest request) {
        return profesorRepository.guardar(new Profesor(
                null,
                request.nombre().trim(),
                request.apellido().trim(),
                request.correo().trim(),
                request.especialidad().trim(),
                request.estado()
        ));
    }

    public List<Profesor> listar(String especialidad) {
        return profesorRepository.listar(especialidad);
    }

    public Profesor obtenerPorId(Long id) {
        return profesorRepository.buscarPorId(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("No existe el profesor con id " + id));
    }
}
