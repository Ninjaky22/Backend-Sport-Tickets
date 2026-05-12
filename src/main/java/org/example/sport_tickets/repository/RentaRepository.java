package org.example.sport_tickets.repository;

import org.example.sport_tickets.model.Renta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentaRepository extends JpaRepository<Renta, Long> {

    // Cambiado: El guion bajo navega hacia la entidad Usuario y busca su campo 'email'
    List<Renta> findByUsuario_Email(String email);
}