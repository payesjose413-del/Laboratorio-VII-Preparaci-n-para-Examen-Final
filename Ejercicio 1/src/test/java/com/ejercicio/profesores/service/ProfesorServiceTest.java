package com.ejercicio.profesores.service;

import com.ejercicio.profesores.dto.CrearProfesorRequest;
import com.ejercicio.profesores.exception.RecursoNoEncontradoException;
import com.ejercicio.profesores.model.Profesor;
import com.ejercicio.profesores.repository.ProfesorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ProfesorServiceTest {

    private ProfesorService profesorService;

    @BeforeEach
    void setUp() {
        profesorService = new ProfesorService(new ProfesorRepository());
    }

    @Test
    void creaProfesor() {
        Profesor profesor = profesorService.crear(new CrearProfesorRequest(
                "Ana", "López", "ana@example.com", "Matemáticas", true
        ));

        assertEquals(1L, profesor.id());
        assertEquals("Ana", profesor.nombre());
        assertEquals("Matemáticas", profesor.especialidad());
        assertEquals(true, profesor.estado());
    }

    @Test
    void obtieneProfesorExistente() {
        Profesor creado = profesorService.crear(new CrearProfesorRequest(
                "Ana", "López", "ana@example.com", "Matemáticas", true
        ));

        assertEquals(creado, profesorService.obtenerPorId(creado.id()));
    }

    @Test
    void lanzaExcepcionSiElProfesorNoExiste() {
        assertThrows(RecursoNoEncontradoException.class, () -> profesorService.obtenerPorId(999L));
    }
}
