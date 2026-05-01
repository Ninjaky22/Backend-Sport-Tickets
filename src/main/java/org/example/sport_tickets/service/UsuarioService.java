package org.example.sport_tickets.service;

import org.example.sport_tickets.model.Usuario;
import org.example.sport_tickets.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public String registrarUsuario(Usuario nuevoUsuario) {
        Usuario usuarioExistente = usuarioRepository.findByEmail(nuevoUsuario.getEmail());
        if (usuarioExistente != null) {
            return "Error: El correo ya está registrado";
        }
        nuevoUsuario.setSuperUser(false);
        usuarioRepository.save(nuevoUsuario);
        return "Registro exitoso";
    }

    public Usuario iniciarSesion(Usuario intentoLogin) {
        Usuario usuarioDB = usuarioRepository.findByEmail(intentoLogin.getEmail());
        if (usuarioDB != null && usuarioDB.getPassword().equals(intentoLogin.getPassword())) {
            return usuarioDB;
        }
        return null;
    }

    public Usuario actualizarUsuario(Long id, Usuario usuarioActualizado) {
        Usuario usuarioDB = usuarioRepository.findById(id).orElse(null);

        if (usuarioDB != null) {
            usuarioDB.setNombreCompleto(usuarioActualizado.getNombreCompleto());
            usuarioDB.setTelefono(usuarioActualizado.getTelefono());
            usuarioDB.setEmail(usuarioActualizado.getEmail());

            if (usuarioActualizado.getFotoUrl() != null && !usuarioActualizado.getFotoUrl().isEmpty()) {
                usuarioDB.setFotoUrl(usuarioActualizado.getFotoUrl());
            }

            if (usuarioActualizado.getPassword() != null && !usuarioActualizado.getPassword().isEmpty()) {
                usuarioDB.setPassword(usuarioActualizado.getPassword());
            }

            return usuarioRepository.save(usuarioDB);
        }
        return null;
    }

    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuarioRepository.findAll();
    }
}