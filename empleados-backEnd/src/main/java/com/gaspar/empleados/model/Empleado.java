package com.gaspar.empleados.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "empleado")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empleado_id")
    Integer id;
    String nombre;
    String correo;

    @Column(name = "fecha_nacimiento")
    LocalDate fechaNacimiento;


    @Column(name = "posicion_id")
    Integer posicionId;
}
