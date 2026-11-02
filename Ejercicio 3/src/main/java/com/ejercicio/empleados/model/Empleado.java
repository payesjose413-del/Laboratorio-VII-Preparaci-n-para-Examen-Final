package com.ejercicio.empleados.model;

public record Empleado(
        Long id,
        String nombre,
        String apellido,
        String correo,
        String especialidad,
        boolean estado
) {
}
