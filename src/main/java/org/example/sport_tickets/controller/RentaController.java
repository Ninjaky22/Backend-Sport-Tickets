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

    // Método para crear una renta (el que usa el Carrito)
    @PostMapping
    public Renta crearRenta(@RequestBody Renta nuevaRenta) {
        nuevaRenta.setFechaRenta(LocalDate.now().toString());
        nuevaRenta.setEstado("Activo");
        return rentaRepository.save(nuevaRenta);
    }

    // Método para ver las rentas de un solo usuario (El que usa "Mis Rentas")
    @GetMapping("/usuario/{email}")
    public List<Renta> obtenerRentasPorUsuario(@PathVariable String email) {
        return rentaRepository.findByUsuarioEmail(email);
    }

    // ¡NUEVO MÉTODO PARA EL ERROR 405! (El que usa el Dashboard de Administrador)
    @GetMapping
    public List<Renta> obtenerTodasLasRentas() {
        return rentaRepository.findAll();
    }
}