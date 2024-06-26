package com.example.hackaton.DTO;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class UsuarioDTO {

    @Getter @Setter
    private String nombre;

    @Getter @Setter
    private String apellido;

    @Getter @Setter
    private String correo;

    @Getter @Setter
    private String ciudad;

    @Getter @Setter
    private String celular;

    @Getter @Setter
    private String contrasena;

    @Getter @Setter
    private List<VueloDTO> vuelos;
   
}
