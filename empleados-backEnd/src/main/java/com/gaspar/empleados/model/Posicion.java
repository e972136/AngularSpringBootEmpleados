package com.gaspar.empleados.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "posicion")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Posicion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "posicion_id")
    Integer id;

    String nombre;
}
