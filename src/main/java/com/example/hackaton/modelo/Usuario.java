package com.example.hackaton.modelo;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long usuarioID;

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

     @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "usuario_vuelo",
               joinColumns = @JoinColumn(name = "usuarioId"),
               inverseJoinColumns = @JoinColumn(name = "vueloId"))
    @JsonIgnore
    @Getter @Setter
    private List<Vuelo> vuelos = new ArrayList<>();
    
}
