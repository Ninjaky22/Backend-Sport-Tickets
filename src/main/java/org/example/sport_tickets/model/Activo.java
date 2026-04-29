package org.example.sport_tickets.model;

import jakarta.persistence.*;

@Entity // Le dice a Java que esta clase es una tabla de la base de datos
@Table(name = "activos") // Nombre de la tabla en Postgres
public class Activo {

    @Id // Define que este campo es la Llave Primaria (el ID único)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Hace que el ID sea 1, 2, 3... automático
    private Long id;

    private String nombre;
    private String categoria;
    private Double precioDia; // Usamos Double para precios con decimales si es necesario
    private Integer stock;
    private String condicion; // "Nuevo", "Usado", "Mantenimiento"
    private String imagenUrl; // Por si luego queremos poner fotos reales

    // --- CONSTRUCTORES (Para crear objetos vacíos o con datos) ---
    public Activo() {
    }

    // --- GETTERS Y SETTERS (Las puertas para leer y escribir los datos) ---
    // Los hacemos a mano para que los puedas mostrar en tu sustentación

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public Double getPrecioDia() { return precioDia; }
    public void setPrecioDia(Double precioDia) { this.precioDia = precioDia; }

    public Integer getStock() { return stock; }
    public void setStock(Integer stock) { this.stock = stock; }

    public String getCondicion() { return condicion; }
    public void setCondicion(String condicion) { this.condicion = condicion; }

    public String getImagenUrl() { return imagenUrl; }
    public void setImagenUrl(String imagenUrl) { this.imagenUrl = imagenUrl; }
}