package org.example.sport_tickets.controller;

import org.example.sport_tickets.model.Usuario;
import org.example.sport_tickets.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/registro")
    public String registrarUsuario(@RequestBody Usuario nuevoUsuario) {
        Usuario usuarioExistente = usuarioRepository.findByEmail(nuevoUsuario.getEmail());
        if (usuarioExistente != null) {
            return "Error: El correo ya está registrado";
        }
        nuevoUsuario.setSuperUser(false);
        usuarioRepository.save(nuevoUsuario);
        return "Registro exitoso";
    }

    @PostMapping("/login")
    public Usuario iniciarSesion(@RequestBody Usuario intentoLogin) {
        Usuario usuarioDB = usuarioRepository.findByEmail(intentoLogin.getEmail());
        if (usuarioDB != null && usuarioDB.getPassword().equals(intentoLogin.getPassword())) {
            return usuarioDB;
        }
        return null;
    }

    @PutMapping("/actualizar")
    public Usuario actualizarUsuario(@RequestBody Usuario usuarioActualizado) {

        // ESCUDO CONTRA EL ERROR 500: Si el ID es nulo, no hacemos la búsqueda
        if (usuarioActualizado.getId() == null) {
            return null;
        }

        Usuario usuarioDB = usuarioRepository.findById(usuarioActualizado.getId()).orElse(null);

        if (usuarioDB != null) {
            usuarioDB.setNombreCompleto(usuarioActualizado.getNombreCompleto());
            usuarioDB.setTelefono(usuarioActualizado.getTelefono());
            usuarioDB.setEmail(usuarioActualizado.getEmail());

            if (usuarioActualizado.getFotoUrl() != null) {
                usuarioDB.setFotoUrl(usuarioActualizado.getFotoUrl());
            }

            if (usuarioActualizado.getPassword() != null && !usuarioActualizado.getPassword().isEmpty()) {
                usuarioDB.setPassword(usuarioActualizado.getPassword());
            }

            return usuarioRepository.save(usuarioDB);
        }
        return null;
    }
}