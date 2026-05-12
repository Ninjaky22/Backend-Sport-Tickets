package org.example.sport_tickets.service;

import org.example.sport_tickets.model.Activo;
import org.example.sport_tickets.model.Renta;
import org.example.sport_tickets.model.Usuario;
import org.example.sport_tickets.repository.ActivoRepository;
import org.example.sport_tickets.repository.RentaRepository;
import org.example.sport_tickets.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RentaService {

    @Autowired
    private RentaRepository rentaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ActivoRepository activoRepository;

    public Renta crearRenta(Long usuarioId, Long activoId, Integer dias) {

        // 1. Buscamos el Usuario
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Error: Usuario no encontrado"));

        // 2. Buscamos el Activo
        Activo activo = activoRepository.findById(activoId)
                .orElseThrow(() -> new RuntimeException("Error: Activo no encontrado"));

        // 3. Armamos la nueva Renta
        Renta nuevaRenta = new Renta();
        nuevaRenta.setUsuario(usuario);
        nuevaRenta.setActivo(activo);
        nuevaRenta.setDias(dias);

        // 4. Calculamos el total automáticamente
        nuevaRenta.setTotalPagado(activo.getPrecioDia() * dias);
        nuevaRenta.setFechaRenta(LocalDate.now().toString());
        nuevaRenta.setEstado("Pendiente");

        return rentaRepository.save(nuevaRenta);
    }

    public List<Renta> obtenerRentasPorUsuario(String email) {
        return rentaRepository.findByUsuario_Email(email);
    }

    public List<Renta> obtenerTodasLasRentas() {
        return rentaRepository.findAll();
    }

    public Renta actualizarEstadoRenta(Long id, Renta rentaActualizada) {
        Renta rentaDB = rentaRepository.findById(id).orElse(null);
        if (rentaDB != null) {
            rentaDB.setEstado(rentaActualizada.getEstado());
            return rentaRepository.save(rentaDB);
        }
        return null;
    }
}