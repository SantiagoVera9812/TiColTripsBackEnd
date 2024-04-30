package com.example.hackaton.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Precio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long precioId;

    @Getter @Setter
    private String currency;

    @Getter @Setter
    private String precio;

     @OneToOne(mappedBy = "precio")

    private Vuelo vuelo;
   
}
