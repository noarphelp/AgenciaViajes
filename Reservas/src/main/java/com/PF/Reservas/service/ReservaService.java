package com.PF.Reservas.service;

import com.PF.Reservas.Dto.HotelDto;
import com.PF.Reservas.Dto.ReservaDto;
import com.PF.Reservas.model.Reservas;
import com.PF.Reservas.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientResponseException;

import java.util.List;

@Service
public class ReservaService implements ReservaSeviceImpl {

    @Value("${mi.appvuelos.url}")
    private String urlVuelos;
    @Value("${mi.apphotel.url}")
    private String urlHoteles;

    private RestClient restClient;

    private ReservaRepository reservaRepository;

    public ReservaService(RestClient.Builder restClientBuilder, ReservaRepository reservaRepository) {
        this.restClient = restClientBuilder.build();
        this.reservaRepository = reservaRepository;

    }

    @Override
    public void saveReserva(ReservaDto reservaDto) {
        try {
            int personas = reservaDto.getCantidadPersonas();

            // Consultar la API de vuelos para ver si hay plazas suficientes
            Integer plazasDisponibles = restClient.get()
                    .uri(urlVuelos + "/vuelos/plazasId/" + reservaDto.getIdVuelo())
                    .retrieve()
                    .body(Integer.class);

            if (plazasDisponibles == null || plazasDisponibles < personas) {
                throw new RuntimeException("No hay suficientes plazas disponibles en el vuelo.");
            }

            //  actualizar las plazas en la API de vuelos
            ResponseEntity<Void> response = restClient.put()
                    .uri(urlVuelos + "/vuelos/update/" + reservaDto.getIdVuelo() + "/" + personas)
                    .retrieve()
                    .toBodilessEntity();

            if (!response.getStatusCode().is2xxSuccessful()) {
                throw new RuntimeException("Error al actualizar las plazas del vuelo.");
            }

            // Si la actualización fue exitosa, guardar la reserva en la base de datos
            Reservas reservas = new Reservas();
            reservas.setNombreCliente(reservaDto.getNombreCliente());
            reservas.setDniCliente(reservaDto.getDniCliente());
            reservas.setIdVuelo(reservaDto.getIdVuelo());
            reservas.setIdHotel(reservaDto.getIdHotel());

            reservaRepository.save(reservas);

        } catch (RestClientResponseException e) {
            // Capturar el mensaje de error de la API de vuelos sin mostrar el código 400
            String errorMessage = e.getResponseBodyAsString();
            throw new RuntimeException(errorMessage);

        } catch (Exception e) {
            throw new RuntimeException( e.getMessage());
        }
    }



    @Override
    public List<Reservas> getInfoReserva(String nombreHotel) {
        try {HotelDto hotel= restClient.get()
                .uri( urlHoteles+"/hotel/nombre/" + nombreHotel)
                .retrieve()
                .body(HotelDto.class);

        return allReservasPorIdHotel(hotel.getIdHotel());
    } catch (Exception e) {
            throw new RuntimeException("No se encontraron reservas para el hotel con nombre: " + nombreHotel);
        }
    }


    @Override
    public List<Reservas> allReservasPorIdHotel(Long idHotel) {
        List<Reservas> reservas = reservaRepository.findAllByIdHotel(idHotel);

        if (!reservas.isEmpty()) {
            return reservas;
        }
        throw new RuntimeException("No se encontraron reservas para el hotel con id: " + idHotel);
    }



}
