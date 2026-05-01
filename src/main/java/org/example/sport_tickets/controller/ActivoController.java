package org.example.sport_tickets.controller;

import org.example.sport_tickets.model.Activo;
import org.example.sport_tickets.service.ActivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/activos")
@CrossOrigin(origins = "*")
public class ActivoController {

    // Ya no inyectamos el Repository, inyectamos el Service
    @Autowired
    private ActivoService activoService;

    @GetMapping
    public List<Activo> listarTodos() {
        return activoService.obtenerTodos();
    }

    @PostMapping
    public Activo crearActivo(@RequestBody Activo activo) {
        return activoService.guardarNuevo(activo);
    }

    @PutMapping("/{id}")
    public Activo actualizarActivo(@PathVariable Long id, @RequestBody Activo activo) {
        return activoService.actualizarActivo(id, activo);
    }

    @DeleteMapping("/{id}")
    public void eliminarActivo(@PathVariable Long id) {
        activoService.eliminarActivo(id);
    }
}