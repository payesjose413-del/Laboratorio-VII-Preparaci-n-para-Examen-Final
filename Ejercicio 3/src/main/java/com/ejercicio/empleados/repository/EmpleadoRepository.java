package com.ejercicio.empleados.repository;

import com.ejercicio.empleados.model.Empleado;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class EmpleadoRepository {

    private final List<Empleado> empleados = new CopyOnWriteArrayList<>();
    private final AtomicLong siguienteId = new AtomicLong(1);

    public Empleado guardar(Empleado empleado) {
        Empleado nuevoEmpleado = new Empleado(
                siguienteId.getAndIncrement(),
                empleado.nombre(),
                empleado.apellido(),
                empleado.correo(),
                empleado.especialidad(),
                empleado.estado()
        );
        empleados.add(nuevoEmpleado);
        return nuevoEmpleado;
    }

    public List<Empleado> listar(String especialidad) {
        return empleados.stream()
                .filter(empleado -> especialidad == null
                        || empleado.especialidad().equalsIgnoreCase(especialidad))
                .sorted((primero, segundo) -> primero.id().compareTo(segundo.id()))
                .toList();
    }

    public Optional<Empleado> buscarPorId(Long id) {
        return empleados.stream()
                .filter(empleado -> empleado.id().equals(id))
                .findFirst();
    }
}
