package org.example.sport_tickets.repository;

import org.example.sport_tickets.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Método mágico: Spring Boot entiende que debe buscar en la columna "email"
    Usuario findByEmail(String email);
}