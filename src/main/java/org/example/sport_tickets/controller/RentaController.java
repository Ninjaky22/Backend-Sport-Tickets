package org.example.sport_tickets.controller;

import org.example.sport_tickets.model.Renta;
import org.example.sport_tickets.repository.RentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/rentas")
@CrossOrigin(origins = "*")
public class RentaController {

    @Autowired
    private RentaRepository rentaRepository;

    // Obtener las rentas de un usuario específico
    @GetMapping("/usuario/{email}")
    public List<Renta> obtenerRentasDeUsuario(@PathVariable String email) {
        return rentaRepository.findByUsuarioEmail(email);
    }

    // Crear una nueva renta (Cuando le den "Pagar" en el carrito)
    @PostMapping
    public Renta crearRenta(@RequestBody Renta nuevaRenta) {
        // Le asignamos la fecha exacta del servidor
        nuevaRenta.setFechaRenta(LocalDate.now().toString());
        // Por defecto, toda renta nueva nace "Activa"
        nuevaRenta.setEstado("Activa");

        return rentaRepository.save(nuevaRenta);
    }
}