package com.PF.Reservas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Reservas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReserva;

    private String nombreCliente;

    private String dniCliente;

    private Long idVuelo;

    private  Long idHotel;


    public Reservas() {
    }

    public Reservas( String nombreCliente, String dniCliente, Long idVuelo, Long idHotel) {
        this.idReserva = idReserva;
        this.nombreCliente = nombreCliente;
        this.dniCliente = dniCliente;
        this.idVuelo = idVuelo;
        this.idHotel = idHotel;
    }

    public Long getIdReserva() {
        return idReserva;
    }


    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
    }

    public Long getIdVuelo() {
        return idVuelo;
    }


    public Long getIdHotel() {
        return idHotel;
    }

    public void setIdVuelo(Long idVuelo) {
        this.idVuelo = idVuelo;
    }

    public void setIdHotel(Long idHotel) {
        this.idHotel = idHotel;
    }
}
