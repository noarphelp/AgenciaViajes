package com.PF.Hoteles.controller;

import com.PF.Hoteles.model.Hotel;
import com.PF.Hoteles.service.service.HotelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("hotel")
public class HotelController {

    @Autowired
    private  HotelService hotelService;

    @GetMapping("/all")
    public List<Hotel> allHoteles() {
        return hotelService.allHoteles();
    }

    @GetMapping("/{idHotel}")
    public ResponseEntity<?> hotelId(@PathVariable Long idHotel) {
        try {
            return ResponseEntity.ok(hotelService.hotelId(idHotel));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<?> hotelName( @PathVariable String nombre) {

       try{
           return ResponseEntity.ok(hotelService.hotelName(nombre));

       }catch (RuntimeException e){
              return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
       }
    }


    @PostMapping("/new")
    public ResponseEntity<?>newHotel(@Valid @RequestBody Hotel hotel, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            List<String> errors = bindingResult.getFieldErrors()
                    .stream()
                    .map(err -> "El campo " + err.getField() + ": " + err.getDefaultMessage())
                    .collect(Collectors.toList());
            return ResponseEntity.badRequest().body(errors);
        }
       Hotel nuevoHotel = hotelService.newHotel(hotel);
        return ResponseEntity.ok(nuevoHotel);
    }

    @PutMapping("/update/{idHotel}")
    public ResponseEntity<?> updateHotel( @PathVariable Long idHotel, @Valid @RequestBody Hotel hotel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<String> errors = bindingResult.getFieldErrors()
                    .stream()
                    .map(err -> "El campo " + err.getField() + ": " + err.getDefaultMessage())
                    .collect(Collectors.toList());
            return ResponseEntity.badRequest().body(errors);
        }

        try {
            return ResponseEntity.ok(hotelService.updateHotel(idHotel, hotel));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{idHotel}")
    public ResponseEntity<?> deleteHotel(@PathVariable Long idHotel) {
        try {
            hotelService.deleteHotel(idHotel);
            return ResponseEntity.ok("Hotel eliminado");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


}
