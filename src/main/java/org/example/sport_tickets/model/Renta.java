package org.example.sport_tickets.model;

import jakarta.persistence.*;

@Entity
@Table(name = "rentas")
public class Renta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // RELACIÓN: Una renta pertenece a un usuario específico.
    // Sustituye al campo 'usuarioEmail' porque ya tenemos acceso a todo el objeto Usuario.
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    // RELACIÓN: Una renta está vinculada a un activo (artículo).
    // Sustituye a 'articuloNombre' e 'imagenUrl'.
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "activo_id", nullable = false)
    private Activo activo;

    private Integer dias;
    private Double totalPagado;
    private String fechaRenta;
    private String estado; // "Pendiente", "Aceptado", "Denegado", "Devuelto"

    public Renta() {
    }

    // --- GETTERS Y SETTERS ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public Activo getActivo() { return activo; }
    public void setActivo(Activo activo) { this.activo = activo; }

    public Integer getDias() { return dias; }
    public void setDias(Integer dias) { this.dias = dias; }

    public Double getTotalPagado() { return totalPagado; }
    public void setTotalPagado(Double totalPagado) { this.totalPagado = totalPagado; }

    public String getFechaRenta() { return fechaRenta; }
    public void setFechaRenta(String fechaRenta) { this.fechaRenta = fechaRenta; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}