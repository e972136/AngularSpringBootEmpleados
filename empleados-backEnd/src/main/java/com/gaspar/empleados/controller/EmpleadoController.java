package com.gaspar.empleados.controller;

import com.gaspar.empleados.model.Empleado;
import com.gaspar.empleados.service.EmpleadoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleado")
public class EmpleadoController {

    private final EmpleadoService empleadoService;

    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @GetMapping("/listado")
    public ResponseEntity<List<Empleado>> listado(){
        return ResponseEntity.ok(empleadoService.listado());
    }

    @PutMapping("/")
    public ResponseEntity<Empleado> guardar(
            @RequestBody Empleado nuevo
    ){
        return ResponseEntity.ok(empleadoService.guardar(nuevo));
    }
}
