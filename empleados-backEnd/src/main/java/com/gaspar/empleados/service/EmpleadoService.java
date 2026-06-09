package com.gaspar.empleados.service;

import com.gaspar.empleados.model.Empleado;
import com.gaspar.empleados.repository.EmpleadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService {
    private final EmpleadoRepository empleadoRepository;

    public EmpleadoService(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    public List<Empleado> listado() {
        return empleadoRepository.findAll();
    }

    public Empleado guardar(Empleado nuevo) {
        return empleadoRepository.save(nuevo);
    }

    public Empleado obtenerId(Integer id) {
        return empleadoRepository.findById(id)
                .orElse(new Empleado());
    }
}
