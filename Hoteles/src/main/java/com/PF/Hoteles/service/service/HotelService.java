package com.PF.Hoteles.service.service;


import com.PF.Hoteles.model.Hotel;
import com.PF.Hoteles.repository.HotelRepository;
import com.PF.Hoteles.service.ImpServiceHotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelService implements ImpServiceHotel {

    private HotelRepository hotelRepository;


    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;


    }


    @Override
    public List<Hotel> allHoteles() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel hotelId(Long idHotel) {

        return  hotelRepository.findById(idHotel).orElseThrow(()-> new RuntimeException("Hotel no encontrado por identificador"));
    }

    @Override
    public Hotel hotelName(String nombre) {
        Hotel hotel = hotelRepository.findByNombre(nombre);
        if(hotel == null){
            throw new RuntimeException("Hotel no encontrado,introdusca un nombre valido");


        }
        return hotel;
    }

    @Override
    public Hotel newHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel updateHotel(Long idHotel, Hotel hotel) {
        Optional<Hotel> optionalHotel= hotelRepository.findById(idHotel);
        if(optionalHotel.isPresent()){
            Hotel hotelUpdate = optionalHotel.get();
            hotelUpdate.setNombre(hotel.getNombre());
            hotelUpdate.setCategoria(hotel.getCategoria());
            hotelUpdate.setPrecio(hotel.getPrecio());
            hotelUpdate.setDisponible(hotel.isDisponible());
            return hotelRepository.save(hotelUpdate);

        }
        throw new RuntimeException("Hotel no encontrado por identificador");
    }


    @Override
    public void deleteHotel(Long idHotel) {
        Optional<Hotel> hotel = hotelRepository.findById(idHotel);

        if (hotel.isPresent()) {
            hotelRepository.deleteById(idHotel);
        } else {
            throw new RuntimeException("Hotel no encontrado por identificador");
        }
    }
}
