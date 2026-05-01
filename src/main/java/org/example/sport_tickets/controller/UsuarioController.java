package org.example.sport_tickets.controller;

import org.example.sport_tickets.model.Usuario;
import org.example.sport_tickets.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/registro")
    public String registrarUsuario(@RequestBody Usuario nuevoUsuario) {
        return usuarioService.registrarUsuario(nuevoUsuario);
    }

    @PostMapping("/login")
    public Usuario iniciarSesion(@RequestBody Usuario intentoLogin) {
        return usuarioService.iniciarSesion(intentoLogin);
    }

    // Ruta corregida a /{id} para que encaje perfectamente con el Frontend
    @PutMapping("/{id}")
    public Usuario actualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuarioActualizado) {
        return usuarioService.actualizarUsuario(id, usuarioActualizado);
    }

    @GetMapping
    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuarioService.obtenerTodosLosUsuarios();
    }
}