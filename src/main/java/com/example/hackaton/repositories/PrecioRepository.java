package com.example.hackaton.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hackaton.modelo.Precio;

public interface PrecioRepository extends JpaRepository<Precio,Long> {

}
