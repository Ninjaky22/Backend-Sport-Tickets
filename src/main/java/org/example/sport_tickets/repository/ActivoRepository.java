package org.example.sport_tickets.repository;

import org.example.sport_tickets.model.Activo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivoRepository extends JpaRepository<Activo, Long> {
    // ¡Aquí no hay que escribir nada de código!
    // JpaRepository ya trae programados los métodos de guardar, buscar, borrar y actualizar.
}