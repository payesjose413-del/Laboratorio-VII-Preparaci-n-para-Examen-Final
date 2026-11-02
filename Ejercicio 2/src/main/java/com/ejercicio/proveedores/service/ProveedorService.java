package com.ejercicio.proveedores.service;

import com.ejercicio.proveedores.dto.CrearProveedorRequest;
import com.ejercicio.proveedores.exception.RecursoNoEncontradoException;
import com.ejercicio.proveedores.model.Proveedor;
import com.ejercicio.proveedores.repository.ProveedorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorService {

    private final ProveedorRepository proveedorRepository;

    public ProveedorService(ProveedorRepository proveedorRepository) {
        this.proveedorRepository = proveedorRepository;
    }

    public Proveedor crear(CrearProveedorRequest request) {
        return proveedorRepository.guardar(new Proveedor(
                null,
                request.nombre().trim(),
                request.apellido().trim(),
                request.correo().trim(),
                request.categoria().trim(),
                request.estado()
        ));
    }

    public List<Proveedor> listar(String categoria) {
        return proveedorRepository.listar(categoria);
    }

    public Proveedor obtenerPorId(Long id) {
        return proveedorRepository.buscarPorId(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("No existe el proveedor con id " + id));
    }
}
