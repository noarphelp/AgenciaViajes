package com.PF.Reservas.repository;

import com.PF.Reservas.model.Role;
import com.PF.Reservas.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario ,Long> {

    Optional<Usuario> findByName(String name);



}
