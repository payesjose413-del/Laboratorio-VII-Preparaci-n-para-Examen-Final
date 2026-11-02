package com.ejercicio.empleados.service;

import com.ejercicio.empleados.dto.CrearEmpleadoRequest;
import com.ejercicio.empleados.exception.RecursoNoEncontradoException;
import com.ejercicio.empleados.model.Empleado;
import com.ejercicio.empleados.repository.EmpleadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService {

    private final EmpleadoRepository empleadoRepository;

    public EmpleadoService(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    public Empleado crear(CrearEmpleadoRequest request) {
        return empleadoRepository.guardar(new Empleado(
                null,
                request.nombre().trim(),
                request.apellido().trim(),
                request.correo().trim(),
                request.especialidad().trim(),
                request.estado()
        ));
    }

    public List<Empleado> listar(String especialidad) {
        return empleadoRepository.listar(especialidad);
    }

    public Empleado obtenerPorId(Long id) {
        return empleadoRepository.buscarPorId(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("No existe el empleado con id " + id));
    }
}
