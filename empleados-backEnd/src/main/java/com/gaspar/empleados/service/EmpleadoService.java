package com.gaspar.empleados.service;

import com.gaspar.empleados.dto.EmpleadoResponse;
import com.gaspar.empleados.model.Empleado;
import com.gaspar.empleados.model.Posicion;
import com.gaspar.empleados.repository.EmpleadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EmpleadoService {
    private final EmpleadoRepository empleadoRepository;
    private final PosicionService posicionService;

    public EmpleadoService(EmpleadoRepository empleadoRepository, PosicionService posicionService) {
        this.empleadoRepository = empleadoRepository;
        this.posicionService = posicionService;
    }

    public List<EmpleadoResponse> listado() {
        Map<Integer, Posicion> mapa = posicionService.mapa();
        return empleadoRepository.findAll().stream().map(e->new EmpleadoResponse(
                e.getId(),
                e.getNombre(),
                e.getCorreo(),
                e.getFechaNacimiento(),
                e.getPosicionId(),
                mapa.get(e.getPosicionId()).getNombre()
        )).toList();
    }

    public EmpleadoResponse guardar(Empleado nuevo) {
        Map<Integer, Posicion> mapa = posicionService.mapa();
        Empleado e = empleadoRepository.save(nuevo);
        return new EmpleadoResponse(
                e.getId(),
                e.getNombre(),
                e.getCorreo(),
                e.getFechaNacimiento(),
                e.getPosicionId(),
                mapa.get(e.getPosicionId()).getNombre()
        );
    }

    public EmpleadoResponse obtenerId(Integer id) {
        Map<Integer, Posicion> mapa = posicionService.mapa();
        return empleadoRepository.findById(id)
                .map(
                        e->new EmpleadoResponse(
                                e.getId(),
                                e.getNombre(),
                                e.getCorreo(),
                                e.getFechaNacimiento(),
                                e.getPosicionId(),
                                mapa.get(e.getPosicionId()).getNombre()
                )).orElse(new EmpleadoResponse(0,"","",null,0,""));
    }
}
