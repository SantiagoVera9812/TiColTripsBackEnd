package com.example.hackaton.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.hackaton.modelo.Vuelo;

@Repository
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public interface VueloRepository extends JpaRepository<Vuelo,Long>{

    @Query("SELECT uv.vuelo FROM UsuarioVuelo uv WHERE uv.usuario.id = :usuarioId")
    List<Vuelo> findByUsuarioId(@Param("usuarioId") Long usuarioId);
    
} 