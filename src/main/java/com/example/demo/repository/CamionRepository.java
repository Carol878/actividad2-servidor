package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.modelo.Camion;
import com.example.demo.modelo.EstadoCamion;
import com.example.demo.modelo.Usuario;

public interface CamionRepository extends MongoRepository<Camion, String> {
    
    // Busca los camiones de un conductor específico
    List<Camion> findByConductor(Usuario conductor);
    
    // Busca camiones disponibles de un conductor
    List<Camion> findByConductorAndEstado(Usuario conductor, EstadoCamion estado);
}
