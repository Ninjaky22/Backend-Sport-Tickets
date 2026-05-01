package org.example.sport_tickets.model;

import jakarta.persistence.*;

@Entity
@Table(name = "activos")
public class Activo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String categoria;
    private Double precioDia;

    // NUEVO: Para saber cuántos tenemos en total en bodega
    private Integer cantidadTotal;

    @Column(columnDefinition = "TEXT")
    private String imagenUrl;

    public Activo() {}

    // GETTERS Y SETTERS
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public Double getPrecioDia() { return precioDia; }
    public void setPrecioDia(Double precioDia) { this.precioDia = precioDia; }

    public Integer getCantidadTotal() { return cantidadTotal; }
    public void setCantidadTotal(Integer cantidadTotal) { this.cantidadTotal = cantidadTotal; }

    public String getImagenUrl() { return imagenUrl; }
    public void setImagenUrl(String imagenUrl) { this.imagenUrl = imagenUrl; }
}