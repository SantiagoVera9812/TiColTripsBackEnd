package com.example.hackaton.DTO;

import lombok.Getter;
import lombok.Setter;

public class ParadaDTO {

      @Getter @Setter
    private String llegada;

    @Getter @Setter
    private String salida;

    @Getter @Setter
    private String avion;

    @Getter @Setter
    private VueloDTO vuelo;
    
}
