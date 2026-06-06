package com.gaspar.empleados.controller;

import com.gaspar.empleados.model.Posicion;
import com.gaspar.empleados.service.PosicionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/posicion")
public class PosicionController {
    private final PosicionService posicionService;

    public PosicionController(PosicionService posicionService) {
        this.posicionService = posicionService;
    }

    @GetMapping("/listado")
    public ResponseEntity<List<Posicion>> listado(){
        return ResponseEntity.ok(posicionService.listado());
    }
}
