package com.PF.Reservas.repository;

import com.PF.Reservas.model.Reservas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservaRepository  extends JpaRepository<Reservas, Long> {

 List<Reservas> findAllByIdHotel(Long idHotel);
}
