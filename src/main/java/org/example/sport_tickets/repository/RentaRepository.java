package org.example.sport_tickets.repository;

import org.example.sport_tickets.model.Renta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentaRepository extends JpaRepository<Renta, Long> {

    // Este método mágico trae solo las rentas de un usuario en específico
    List<Renta> findByUsuarioEmail(String usuarioEmail);
}