package org.example.sport_tickets.service;

import org.example.sport_tickets.model.Renta;
import org.example.sport_tickets.repository.RentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RentaService {

    @Autowired
    private RentaRepository rentaRepository;

    public Renta crearRenta(Renta nuevaRenta) {
        nuevaRenta.setFechaRenta(LocalDate.now().toString());
        nuevaRenta.setEstado("Pendiente");
        return rentaRepository.save(nuevaRenta);
    }

    public List<Renta> obtenerRentasPorUsuario(String email) {
        return rentaRepository.findByUsuarioEmail(email);
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