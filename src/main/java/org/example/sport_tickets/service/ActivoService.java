package org.example.sport_tickets.service;

import org.example.sport_tickets.model.Activo;
import org.example.sport_tickets.repository.ActivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ActivoService {

    @Autowired
    private ActivoRepository activoRepository;

    // Asegúrate de agregar este import arriba del todo:
    // import org.springframework.data.domain.Sort;

    public List<Activo> obtenerTodos() {
        // AQUÍ ESTÁ LA MAGIA: Forzamos el orden ascendente por ID
        return activoRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    public Activo guardarNuevo(Activo activo) {
        // Validamos que por defecto la cantidad mínima sea 1 si se les olvidó mandarla
        if (activo.getCantidadTotal() == null || activo.getCantidadTotal() < 1) {
            activo.setCantidadTotal(1);
        }
        return activoRepository.save(activo);
    }

    public Activo actualizarActivo(Long id, Activo datosActualizados) {
        Activo activoDB = activoRepository.findById(id).orElse(null);
        if (activoDB != null) {
            activoDB.setNombre(datosActualizados.getNombre());
            activoDB.setCategoria(datosActualizados.getCategoria());
            activoDB.setPrecioDia(datosActualizados.getPrecioDia());
            activoDB.setCantidadTotal(datosActualizados.getCantidadTotal());

            if (datosActualizados.getImagenUrl() != null && !datosActualizados.getImagenUrl().isEmpty()) {
                activoDB.setImagenUrl(datosActualizados.getImagenUrl());
            }
            return activoRepository.save(activoDB);
        }
        return null;
    }

    public boolean eliminarActivo(Long id) {
        if (activoRepository.existsById(id)) {
            activoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}