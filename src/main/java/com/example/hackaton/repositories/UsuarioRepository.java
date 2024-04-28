package com.example.hackaton.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.hackaton.modelo.Usuario;

@Repository
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public interface UsuarioRepository extends JpaRepository<Usuario,Long>{

    @Query("SELECT u FROM Usuario u WHERE u.correo = :correo AND u.contrasena = :contrasena")
    Usuario findByCorreoAndContrasena(@Param("correo") String correo, @Param("contrasena") String contrasena);
   
}
