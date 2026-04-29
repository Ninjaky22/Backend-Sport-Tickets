package org.example.sport_tickets.controller;

import org.example.sport_tickets.model.Activo;
import org.example.sport_tickets.repository.ActivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Le dice a Java que esta clase va a responder peticiones de internet
@RequestMapping("/api/activos") // La URL por donde el mesero atiende
@CrossOrigin(origins = "*") // Permite que tu HTML se conecte sin problemas de seguridad
public class ActivoController {

    @Autowired
    private ActivoRepository activoRepository; // Llamamos a nuestro "cocinero"

    // Método para OBTENER todos los activos (GET)
    @GetMapping
    public List<Activo> listarActivos() {
        return activoRepository.findAll(); // Va a la base de datos y trae todo
    }

    // Método para GUARDAR un nuevo activo (POST)
    @PostMapping
    public Activo crearActivo(@RequestBody Activo nuevoActivo) {
        return activoRepository.save(nuevoActivo); // Guarda el objeto en la base de datos
    }
}