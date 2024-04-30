package com.example.hackaton.DTO;

import lombok.Getter;
import lombok.Setter;

public class PrecioDTO {

    @Getter @Setter
    private String currency;

    @Getter @Setter
    private String precio;
    
    @Getter @Setter
    private VueloDTO vuelo;
    
}
