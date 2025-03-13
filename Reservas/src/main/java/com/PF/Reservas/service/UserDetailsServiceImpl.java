package com.PF.Reservas.service;

import com.PF.Reservas.model.Usuario;
import com.PF.Reservas.repository.UsuarioRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UsuarioRepository repository;

    public UserDetailsServiceImpl(UsuarioRepository repository) {
        this.repository = repository;
    }


        @Override
        public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
            Usuario usuario = repository.findByName(name)
                    .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con el nombre: " + name));

            // Agregamos el prefijo "ROLE_" si el valor en la BD no lo tiene
            String role = usuario.getRole().name().startsWith("ROLE_") ? usuario.getRole().name() : "ROLE_" + usuario.getRole().name();

            List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(role));

            System.out.println("Usuario: " + usuario.getName());
            System.out.println("Roles asignados: " + authorities);

            return new org.springframework.security.core.userdetails.User(
                    usuario.getName(), usuario.getPassword(), authorities);
        }


}
