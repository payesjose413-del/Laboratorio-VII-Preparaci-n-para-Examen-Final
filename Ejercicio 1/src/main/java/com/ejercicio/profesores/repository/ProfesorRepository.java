package com.ejercicio.profesores.repository;

import com.ejercicio.profesores.model.Profesor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ProfesorRepository {

    private final List<Profesor> profesores = new CopyOnWriteArrayList<>();
    private final AtomicLong siguienteId = new AtomicLong(1);

    public Profesor guardar(Profesor profesor) {
        Profesor nuevoProfesor = new Profesor(
                siguienteId.getAndIncrement(),
                profesor.nombre(),
                profesor.apellido(),
                profesor.correo(),
                profesor.especialidad(),
                profesor.estado()
        );
        profesores.add(nuevoProfesor);
        return nuevoProfesor;
    }

    public List<Profesor> listar(String especialidad) {
        return profesores.stream()
                .filter(profesor -> especialidad == null
                        || profesor.especialidad().equalsIgnoreCase(especialidad))
                .sorted((primero, segundo) -> primero.id().compareTo(segundo.id()))
                .toList();
    }

    public Optional<Profesor> buscarPorId(Long id) {
        return profesores.stream()
                .filter(profesor -> profesor.id().equals(id))
                .findFirst();
    }
}
