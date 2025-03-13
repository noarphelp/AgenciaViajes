package com.PF.Vuelos.repository;

import com.PF.Vuelos.model.Vuelos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VuelosRepository extends JpaRepository<Vuelos, Long> {

    @Query("SELECT v FROM Vuelos v WHERE v.plazasDisponibles >= :plazasDisponibles")
    List<Vuelos> findByPlazasDisponiblesGreaterThanEqual(@Param("plazasDisponibles") int plazasDisponibles);


}

