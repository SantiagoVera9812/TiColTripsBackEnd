package com.example.hackaton.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hackaton.DTO.VueloDTO;
import com.example.hackaton.modelo.Vuelo;
import com.example.hackaton.services.VueloService;


@RestController
@RequestMapping("/Vuelo")
@CrossOrigin(origins = "/http://localhost:4200", allowedHeaders = "*")
public class VueloController {

    @Autowired
    VueloService vueloService;

    @PostMapping("/agregar")
    public Vuelo agregar(@RequestBody VueloDTO vueloDTO) {
        return vueloService.insertar(vueloDTO);
    }
    
    
}
