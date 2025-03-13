package com.PF.Reservas.controller;

import com.PF.Reservas.model.Role;
import com.PF.Reservas.model.Usuario;
import com.PF.Reservas.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private UsuarioService usuarioService;

    private PasswordEncoder passwordEncoder;

    public UsuarioController(UsuarioService usuarioService, PasswordEncoder passwordEncoder) {
        this.usuarioService = usuarioService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/all")
    public List<Usuario> allUser(){

        return usuarioService.listAll();
    }




    @PostMapping("/new")
    public ResponseEntity<?> newUsuario(@RequestBody Usuario usuario){
      try{

         return ResponseEntity.ok( usuarioService.newUsuario(usuario));


      }catch(RuntimeException e){

          return ResponseEntity.badRequest().body("Usuario no registrado correctamente ");
        }

    }


}
