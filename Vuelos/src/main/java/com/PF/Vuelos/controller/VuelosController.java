package com.PF.Vuelos.controller;

import com.PF.Vuelos.model.Vuelos;
import com.PF.Vuelos.service.VuelosService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vuelos")
public class VuelosController {

    private  VuelosService vuelosService;

    public VuelosController(VuelosService vuelosService) {
        this.vuelosService = vuelosService;
    }

    @GetMapping("/all")
    public List<Vuelos> getAllVuelos() {
        return vuelosService.findAll();
    }


    @GetMapping("/plazasId/{vueloId}")
    public ResponseEntity<?> getPlazasDisponibles(@PathVariable Long vueloId) {
        try {
            return ResponseEntity.ok(vuelosService.plazasDisponibles(vueloId));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }


    @GetMapping("/plazas/{plazasDisponibles}")
    public ResponseEntity<?> getVuelosByPlazasDisponibles(@PathVariable int plazasDisponibles) {
        try {
            return ResponseEntity.ok(vuelosService.findByPlazasDisponibles(plazasDisponibles));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @PutMapping("/update/{vueloId}/{plazasReservadas}")
    public ResponseEntity<?> updateVuelo(@PathVariable Long vueloId, @PathVariable int plazasReservadas) {
        try {
            Vuelos vueloActualizado = vuelosService.actualizarVueloPorId(vueloId, plazasReservadas);
            return ResponseEntity.ok(vueloActualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @PostMapping("/new")
    public Vuelos newVuelo(@RequestBody Vuelos vuelo) {
        return vuelosService.newVuelo(vuelo);
    }

    @DeleteMapping("/delete/{vueloId}")
    public void deleteVuelo(@PathVariable Long vueloId) {
        vuelosService.deleteVuelo(vueloId);
    }

    @PutMapping("/update/{vueloId}")
    public Vuelos update(@PathVariable Long vueloId, @RequestBody Vuelos vuelo) {
        return vuelosService.actualizar(vueloId, vuelo);
    }
}
