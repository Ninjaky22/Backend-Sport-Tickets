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

        // Todos los que se registran por la web son usuarios normales
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
}