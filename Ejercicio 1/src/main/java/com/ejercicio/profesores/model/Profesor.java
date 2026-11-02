package com.ejercicio.profesores.model;

public record Profesor(
        Long id,
        String nombre,
        String apellido,
        String correo,
        String especialidad,
        boolean estado
) {
}
