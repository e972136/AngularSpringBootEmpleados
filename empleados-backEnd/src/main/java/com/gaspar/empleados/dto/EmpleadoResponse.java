package com.gaspar.empleados.dto;

import java.time.LocalDate;

public record EmpleadoResponse(
        Integer id,
        String nombre,
        String correo,
        LocalDate fechaNacimiento,
        Integer posicionId,
        String posicion
) {
}
