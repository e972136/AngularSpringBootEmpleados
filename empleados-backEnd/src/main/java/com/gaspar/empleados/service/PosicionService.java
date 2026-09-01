package com.gaspar.empleados.service;

import com.gaspar.empleados.model.Posicion;
import com.gaspar.empleados.repository.PosicionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class PosicionService {
    private final PosicionRepository posicionRepository;

    public PosicionService(PosicionRepository posicionRepository) {
        this.posicionRepository = posicionRepository;
    }

    public List<Posicion> listado() {
        return posicionRepository.findAll();
    }

    public Map<Integer,Posicion> mapa(){
        return posicionRepository.findAll().stream().collect(Collectors.toMap(Posicion::getId, Function.identity()));
    }
}
