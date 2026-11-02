package com.ejercicio.proveedores.service;

import com.ejercicio.proveedores.dto.CrearProveedorRequest;
import com.ejercicio.proveedores.exception.RecursoNoEncontradoException;
import com.ejercicio.proveedores.model.Proveedor;
import com.ejercicio.proveedores.repository.ProveedorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ProveedorServiceTest {

    private ProveedorService proveedorService;

    @BeforeEach
    void setUp() {
        proveedorService = new ProveedorService(new ProveedorRepository());
    }

    @Test
    void creaProveedor() {
        Proveedor proveedor = proveedorService.crear(new CrearProveedorRequest(
                "Ana", "López", "ana@example.com", "Tecnología", true
        ));

        assertEquals(1L, proveedor.id());
        assertEquals("Ana", proveedor.nombre());
        assertEquals("Tecnología", proveedor.categoria());
        assertEquals(true, proveedor.estado());
    }

    @Test
    void obtieneProveedorExistente() {
        Proveedor creado = proveedorService.crear(new CrearProveedorRequest(
                "Ana", "López", "ana@example.com", "Tecnología", true
        ));

        assertEquals(creado, proveedorService.obtenerPorId(creado.id()));
    }

    @Test
    void lanzaExcepcionSiElProveedorNoExiste() {
        assertThrows(RecursoNoEncontradoException.class, () -> proveedorService.obtenerPorId(999L));
    }
}
