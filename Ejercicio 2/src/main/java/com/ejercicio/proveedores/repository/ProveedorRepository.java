package com.ejercicio.proveedores.repository;

import com.ejercicio.proveedores.model.Proveedor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ProveedorRepository {

    private final List<Proveedor> proveedores = new CopyOnWriteArrayList<>();
    private final AtomicLong siguienteId = new AtomicLong(1);

    public Proveedor guardar(Proveedor proveedor) {
        Proveedor nuevoProveedor = new Proveedor(
                siguienteId.getAndIncrement(),
                proveedor.nombre(),
                proveedor.apellido(),
                proveedor.correo(),
                proveedor.categoria(),
                proveedor.estado()
        );
        proveedores.add(nuevoProveedor);
        return nuevoProveedor;
    }

    public List<Proveedor> listar(String categoria) {
        return proveedores.stream()
                .filter(proveedor -> categoria == null
                        || proveedor.categoria().equalsIgnoreCase(categoria))
                .sorted((primero, segundo) -> primero.id().compareTo(segundo.id()))
                .toList();
    }

    public Optional<Proveedor> buscarPorId(Long id) {
        return proveedores.stream()
                .filter(proveedor -> proveedor.id().equals(id))
                .findFirst();
    }
}
