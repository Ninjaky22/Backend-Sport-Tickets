package org.example.sport_tickets.controller;

import org.example.sport_tickets.model.Renta;
import org.example.sport_tickets.service.RentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rentas")
@CrossOrigin(origins = "*")
public class RentaController {

    @Autowired
    private RentaService rentaService;

    @PostMapping
    public Renta crearRenta(@RequestBody Renta nuevaRenta) {
        return rentaService.crearRenta(nuevaRenta);
    }

    @GetMapping("/usuario/{email}")
    public List<Renta> obtenerRentasPorUsuario(@PathVariable String email) {
        return rentaService.obtenerRentasPorUsuario(email);
    }

    @GetMapping
    public List<Renta> obtenerTodasLasRentas() {
        return rentaService.obtenerTodasLasRentas();
    }

    @PutMapping("/{id}")
    public Renta actualizarEstadoRenta(@PathVariable Long id, @RequestBody Renta rentaActualizada) {
        return rentaService.actualizarEstadoRenta(id, rentaActualizada);
    }
}