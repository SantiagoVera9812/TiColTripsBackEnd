package com.example.hackaton.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hackaton.DTO.UsuarioDTO;
import com.example.hackaton.modelo.Usuario;
import com.example.hackaton.services.UsuarioService;


@RestController
@CrossOrigin(origins = "/http://localhost:4200", allowedHeaders = "*")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/registro-usuario")
    public Usuario insertar(@RequestBody UsuarioDTO usuarioDTO) {

        boolean esUsuarioValido = usuarioService.verificarUsuario(usuarioDTO.getCorreo(), usuarioDTO.getContrasena());
        
        if(!esUsuarioValido) {
            return usuarioService.insertar(usuarioDTO);
        } else {
            return null; // Retorna null si el usuario ya existe
        }
    }

    @PostMapping("/inicio-sesion")
    public ResponseEntity<Boolean> verificarUsuario(
            @RequestParam String correo,
            @RequestParam String contraseña) {

        System.out.println(correo);
        System.out.println(contraseña);
        boolean esUsuarioValido = usuarioService.verificarUsuario(correo, contraseña);
        
        
        return ResponseEntity.ok(esUsuarioValido);
    }
    
}
