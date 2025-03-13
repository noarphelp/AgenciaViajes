package com.PF.Hoteles.service;

import com.PF.Hoteles.model.Hotel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ImpServiceHotel {

    List<Hotel> allHoteles();

    Hotel hotelId(Long idHotel);

    Hotel newHotel(Hotel hotel);

    Hotel hotelName(String nombre);

    Hotel updateHotel(Long idHotel, Hotel hotel);

    void deleteHotel(Long idHotel);
}
