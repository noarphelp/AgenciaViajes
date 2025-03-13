package com.PF.Hoteles.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import org.springframework.stereotype.Component;

@Entity
public class Hotel {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long idHotel;
    @Pattern(regexp = "(?i)^[a-záéíóúñ]+$", message = "El nombre solo puede contener letras")
    @NotBlank( message = "El nombre no puede ser nulo")
    private String nombre;
    @NotBlank( message = "La categoria no puede ser nula")
    private String categoria;
    @DecimalMin(value = "1.0", message = "El precio debe ser mayor o igual a 1")
    @DecimalMax(value = "100.0", message = "El precio debe ser menor o igual a 100")
    private double precio;
    @NotNull( message = "Tiene que estar disponible o no")
    private boolean disponible;


    public Hotel() {
    }

    public Hotel(String nombre, String categoria, double precio, boolean disponible) {

        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.disponible = disponible;
    }

    public Long getIdHotel() {
        return idHotel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}
