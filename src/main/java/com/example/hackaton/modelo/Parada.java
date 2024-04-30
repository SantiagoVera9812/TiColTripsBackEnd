package com.example.hackaton.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Parada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long paradaId;
    
    @Getter @Setter
    private String llegada;

    @Getter @Setter
    private String salida;

    @Getter @Setter
    private String avion;

    @ManyToOne()
    @JoinColumn(name = "vueloId")
    @Getter @Setter
    @JsonIgnore
    private Vuelo vuelo;
    
}
