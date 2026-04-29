package org.example.sport_tickets.model;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreCompleto;

    @Column(unique = true)
    private String email;

    private String password;

    // AQUÍ ESTÁ EL CAMBIO A BOOLEANO
    private Boolean superUser;

    public Usuario() {}

    // --- GETTERS Y SETTERS ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombreCompleto() { return nombreCompleto; }
    public void setNombreCompleto(String nombreCompleto) { this.nombreCompleto = nombreCompleto; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    // En los booleanos, el "get" suele llamarse "is"
    public Boolean getSuperUser() { return superUser; }
    public void setSuperUser(Boolean superUser) { this.superUser = superUser; }
}