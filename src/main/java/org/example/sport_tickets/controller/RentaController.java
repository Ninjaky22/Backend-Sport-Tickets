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

    // Clase interna DTO para recibir los datos desde el frontend fácilmente
    public static class RentaRequest {
        private Long usuarioId;
        private Long activoId;
        private Integer dias;

        public Long getUsuarioId() { return usuarioId; }
        public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }
        public Long getActivoId() { return activoId; }
        public void setActivoId(Long activoId) { this.activoId = activoId; }
        public Integer getDias() { return dias; }
        public void setDias(Integer dias) { this.dias = dias; }
    }

    @PostMapping
    public Renta crearRenta(@RequestBody RentaRequest request) {
        return rentaService.crearRenta(request.getUsuarioId(), request.getActivoId(), request.getDias());
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