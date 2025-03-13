package com.PF.Vuelos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Vuelos {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long vueloId;
    private String compañia;
    private LocalDate fechaVuelo;
    private double precio;
    private int plazasDisponibles;

    public Vuelos() {
    }

    public Vuelos(String compañia, LocalDate fechaVuelo, double precio, int plazasDisponibles) {

        this.compañia = compañia;
        this.fechaVuelo = fechaVuelo;
        this.precio = precio;
        this.plazasDisponibles = plazasDisponibles;
    }

    public Long getVueloId() {
        return vueloId;
    }


    public String getCompañia() {
        return compañia;
    }

    public void setCompañia(String compañia) {
        this.compañia = compañia;
    }

    public LocalDate getFechaVuelo() {
        return fechaVuelo;
    }

    public void setFechaVuelo(LocalDate fechaVuelo) {
        this.fechaVuelo = fechaVuelo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getPlazasDisponibles() {
        return plazasDisponibles;
    }

    public void setPlazasDisponibles(int plazasDisponibles) {
        this.plazasDisponibles = plazasDisponibles;
    }
}
