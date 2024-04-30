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
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;


@Entity
public class Vuelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long vueloId;

    @Getter @Setter
    private String lastTicketingDate;

    @Getter @Setter
    private int numeroDeParadas;

    @Getter @Setter
    private int numberOfBookableSeats;

    @Getter @Setter 
    private String validatingAirLineCodes;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "precioId")
    @Getter @Setter
    private Precio precio;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "vueloId") // Adjust this to match your column name
    @JsonIgnore
    @Getter @Setter
    private List<Parada> paradas = new ArrayList<>();


      @ManyToMany(mappedBy = "vuelos")
    @JsonIgnore
    @Getter @Setter
    private List<Usuario> usuarios = new ArrayList<>();
}

