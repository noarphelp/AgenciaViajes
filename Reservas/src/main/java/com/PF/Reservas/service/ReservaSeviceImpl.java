package com.PF.Reservas.service;

import com.PF.Reservas.Dto.ReservaDto;
import com.PF.Reservas.model.Reservas;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReservaSeviceImpl {


    public void saveReserva(ReservaDto reservaDto);

    public List<Reservas> getInfoReserva(String nombreHotel);

    public List<Reservas> allReservasPorIdHotel(Long idHotel);
}
