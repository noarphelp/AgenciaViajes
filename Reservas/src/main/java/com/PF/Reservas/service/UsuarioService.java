package com.PF.Reservas.service;

import com.PF.Reservas.model.Role;
import com.PF.Reservas.model.Usuario;
import com.PF.Reservas.repository.UsuarioRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    private PasswordEncoder encoder;

    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder encoder) {
        this.usuarioRepository = usuarioRepository;
        this.encoder = encoder;
    }




    public Usuario newUsuario(Usuario usuario){

        String user = encoder.encode(usuario.getPassword());
        usuario.setPassword(user);


        return usuarioRepository.save(usuario);
    }


    public List<Usuario> listAll(){

        return usuarioRepository.findAll();
    }
}
