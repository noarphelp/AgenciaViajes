package com.PF.Vuelos.repository;

import com.PF.Vuelos.model.Vuelos;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VuelosImpRepository {

    List<Vuelos> findAll();

    Vuelos actualizarVueloPorId(Long vueloId, int plazasDisponibles);

    Vuelos newVuelo(Vuelos vuelo);

    void deleteVuelo(Long vueloId);

    Vuelos actualizar(Long vueloId, Vuelos vuelo);

  Optional<Integer> plazasDisponibles(Long vueloId);
}
