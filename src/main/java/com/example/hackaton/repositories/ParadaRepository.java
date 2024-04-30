package com.example.hackaton.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hackaton.modelo.Parada;

public interface ParadaRepository extends JpaRepository<Parada,Long> {
    
}
