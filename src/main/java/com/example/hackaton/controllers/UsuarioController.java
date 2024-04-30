package com.example.hackaton.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hackaton.DTO.UsuarioDTO;
import com.example.hackaton.modelo.Usuario;
import com.example.hackaton.modelo.Vuelo;
import com.example.hackaton.services.UsuarioService;
import com.example.hackaton.services.VueloService;


@RestController
@CrossOrigin(origins = "/http://localhost:4200", allowedHeaders = "*")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    VueloService vueloService;

    @PostMapping("/registro-usuario")
    public Usuario insertar(@RequestBody UsuarioDTO usuarioDTO) {

        boolean esUsuarioValido = usuarioService.verificarUsuario(usuarioDTO.getCorreo(), usuarioDTO.getContrasena());
        
        if(!esUsuarioValido) {
            return usuarioService.insertar(usuarioDTO);
        } else {
            return null; // Retorna null si el usuario ya existe
        }
    }

    @PostMapping("/conseguir-info-usuario")
    public Usuario usuario( @RequestParam String correo,
    @RequestParam String contraseña) {

        Usuario usuario = usuarioService.conseguirUsuario(correo, contraseña);
        return usuario;
    }

    @PostMapping("/vuelos-del-usuario")
    public List<Vuelo> listarUsuaioVuelos(@RequestParam Long usuarioId){

        List<Vuelo> listaVuelos = usuarioService.listarVuelosUsuario(usuarioId);
        return listaVuelos;
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
