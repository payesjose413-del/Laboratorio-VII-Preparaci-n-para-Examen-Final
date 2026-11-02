package com.ejercicio.proveedores.model;

public record Proveedor(
        Long id,
        String nombre,
        String apellido,
        String correo,
        String categoria,
        boolean estado
) {
}
