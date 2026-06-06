package com.gaspar.empleados.service;

import com.gaspar.empleados.model.Posicion;
import com.gaspar.empleados.repository.PosicionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PosicionService {
    private final PosicionRepository posicionRepository;

    public PosicionService(PosicionRepository posicionRepository) {
        this.posicionRepository = posicionRepository;
    }

    public List<Posicion> listado() {
        return posicionRepository.findAll();
    }
}
