package com.gaspar.empleados.repository;

import com.gaspar.empleados.model.Posicion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PosicionRepository extends JpaRepository<Posicion,Integer> {
}
