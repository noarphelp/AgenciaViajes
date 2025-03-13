package com.PF.Vuelos.service;

import com.PF.Vuelos.model.Vuelos;
import com.PF.Vuelos.repository.VuelosImpRepository;
import com.PF.Vuelos.repository.VuelosRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@Service
public class VuelosService  implements VuelosImpRepository {
    private final VuelosRepository vuelosRepository;

    public VuelosService(VuelosRepository vuelosRepository) {
        this.vuelosRepository = vuelosRepository;

    }

    public List<Vuelos> findAll() {
        return vuelosRepository.findAll();
    }


    @Override
    public Optional<Integer> plazasDisponibles(Long vueloId) {
        Optional<Vuelos> vuelo = vuelosRepository.findById(vueloId);

        if(vuelo != null) {
            Integer plazas = vuelo.get().getPlazasDisponibles();

            return Optional.of(plazas);
        }
        throw new RuntimeException("Vuelo no encontrado con el id: " + vueloId);
    }

    public List<Vuelos> findByPlazasDisponibles(int plazasDisponibles) {
        if(plazasDisponibles <= 0  || plazasDisponibles > 10) {

           throw new RuntimeException("El número de plazas disponibles debe ser mayor a 0 y menor o igual a 10");

        }

        return vuelosRepository.findByPlazasDisponiblesGreaterThanEqual(plazasDisponibles);
    }

    @Override
    public Vuelos actualizarVueloPorId(Long vueloId, int plazasReservadas) {
        // Buscar el vuelo
        Vuelos vueloActualizado = vuelosRepository.findById(vueloId).orElse(null);

        if (vueloActualizado == null) {
            throw new RuntimeException("El vuelo no existe.");
        }

        if (plazasReservadas > 7) {
            throw new RuntimeException("No se pueden reservar más de 7 plazas por solicitud.");
        }

        if (plazasReservadas > vueloActualizado.getPlazasDisponibles()) {
            throw new RuntimeException("No hay suficientes plazas disponibles.");
        }

        vueloActualizado.setPlazasDisponibles(vueloActualizado.getPlazasDisponibles() - plazasReservadas);
        return vuelosRepository.save(vueloActualizado);
    }


    @Override
    public Vuelos newVuelo(Vuelos vuelo) {
        return vuelosRepository.save(vuelo);
    }

    @Override
    public void deleteVuelo(Long vueloId) {
        vuelosRepository.deleteById(vueloId);

    }

    @Override
    public Vuelos actualizar(Long vueloId, Vuelos vuelo) {
        Vuelos vueloActualizado = vuelosRepository.findById(vueloId).orElseThrow();


        if(vueloActualizado != null) {
           vueloActualizado.setCompañia(vuelo.getCompañia());
              vueloActualizado.setFechaVuelo(vuelo.getFechaVuelo());
                vueloActualizado.setPrecio(vuelo.getPrecio());
                vueloActualizado.setPlazasDisponibles(vuelo.getPlazasDisponibles());

            return vuelosRepository.save(vuelo);
        }
        throw new RuntimeException("Vuelo no encontrado con el id: " + vueloId);
    }
}
