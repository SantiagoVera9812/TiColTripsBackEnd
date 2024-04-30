package com.example.hackaton.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.hackaton.modelo.Vuelo;

@Repository
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public interface VueloRepository extends JpaRepository<Vuelo,Long>{
    
} 