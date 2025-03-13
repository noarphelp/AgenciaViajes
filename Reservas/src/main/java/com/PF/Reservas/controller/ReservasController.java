package com.PF.Reservas.controller;

import com.PF.Reservas.Dto.ReservaDto;
import com.PF.Reservas.model.Reservas;
import com.PF.Reservas.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/reservas")
public class ReservasController {

    private ReservaService reservaService;

    public ReservasController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @GetMapping("/allReservas/{nombreHotel}")
    public ResponseEntity<?> allReservasPorIdHotel(@PathVariable String nombreHotel) {
        try {
            return ResponseEntity.ok(reservaService.getInfoReserva(nombreHotel));
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }

    }


    @PostMapping("/newReserva")
    public ResponseEntity<?> newReserva(@RequestBody ReservaDto reservaDto) {
        try {
            reservaService.saveReserva(reservaDto);
            return ResponseEntity.ok(reservaDto.getNombreCliente() + ", Tu reserva a sido  creada con exito");
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }


}
