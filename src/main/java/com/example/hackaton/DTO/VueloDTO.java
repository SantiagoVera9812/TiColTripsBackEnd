package com.example.hackaton.DTO;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class VueloDTO {

    @Getter @Setter
    private String lastTicketingDate;

    @Getter @Setter
    private int numeroDeParadas;

    @Getter @Setter
    private int numberOfBookableSeats;

    @Getter @Setter 
    private String validatingAirLineCodes;
    
    @Getter @Setter
    private PrecioDTO precio;
    
    @Getter @Setter
    private List<ParadaDTO> paradas;
    
    @Getter @Setter
    private List<UsuarioDTO> usuarios;
   
}
