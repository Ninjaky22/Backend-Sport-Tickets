package org.example.sport_tickets.model;

import jakarta.persistence.*;

@Entity
@Table(name = "rentas")
public class Renta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String usuarioEmail; // El "dueño" de la renta
    private String articuloNombre; // Qué rentó
    private String imagenUrl; // Para mostrar la fotito en la lista
    private Integer dias;
    private Double totalPagado;
    private String fechaRenta;
    private String estado; // Puede ser "Activa" o "Devuelto"

    public Renta() {
    }

    // --- GETTERS Y SETTERS ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsuarioEmail() { return usuarioEmail; }
    public void setUsuarioEmail(String usuarioEmail) { this.usuarioEmail = usuarioEmail; }

    public String getArticuloNombre() { return articuloNombre; }
    public void setArticuloNombre(String articuloNombre) { this.articuloNombre = articuloNombre; }

    public String getImagenUrl() { return imagenUrl; }
    public void setImagenUrl(String imagenUrl) { this.imagenUrl = imagenUrl; }

    public Integer getDias() { return dias; }
    public void setDias(Integer dias) { this.dias = dias; }

    public Double getTotalPagado() { return totalPagado; }
    public void setTotalPagado(Double totalPagado) { this.totalPagado = totalPagado; }

    public String getFechaRenta() { return fechaRenta; }
    public void setFechaRenta(String fechaRenta) { this.fechaRenta = fechaRenta; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}