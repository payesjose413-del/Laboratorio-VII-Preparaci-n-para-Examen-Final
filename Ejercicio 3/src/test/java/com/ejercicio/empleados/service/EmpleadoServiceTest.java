package com.ejercicio.empleados.service;

import com.ejercicio.empleados.dto.CrearEmpleadoRequest;
import com.ejercicio.empleados.exception.RecursoNoEncontradoException;
import com.ejercicio.empleados.model.Empleado;
import com.ejercicio.empleados.repository.EmpleadoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EmpleadoServiceTest {

    private EmpleadoService empleadoService;

    @BeforeEach
    void setUp() {
        empleadoService = new EmpleadoService(new EmpleadoRepository());
    }

    @Test
    void creaEmpleado() {
        Empleado empleado = empleadoService.crear(new CrearEmpleadoRequest(
                "Ana", "López", "ana@example.com", "Contabilidad", true
        ));

        assertEquals(1L, empleado.id());
        assertEquals("Ana", empleado.nombre());
        assertEquals("Contabilidad", empleado.especialidad());
        assertEquals(true, empleado.estado());
    }

    @Test
    void obtieneEmpleadoExistente() {
        Empleado creado = empleadoService.crear(new CrearEmpleadoRequest(
                "Ana", "López", "ana@example.com", "Contabilidad", true
        ));

        assertEquals(creado, empleadoService.obtenerPorId(creado.id()));
    }

    @Test
    void lanzaExcepcionSiElEmpleadoNoExiste() {
        assertThrows(RecursoNoEncontradoException.class, () -> empleadoService.obtenerPorId(999L));
    }
}
