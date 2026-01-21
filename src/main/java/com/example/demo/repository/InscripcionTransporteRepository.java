package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.modelo.Camion;
import com.example.demo.modelo.InscripcionTransporte;
import com.example.demo.modelo.Mercancia;

public interface InscripcionTransporteRepository extends MongoRepository<InscripcionTransporte, String> {
    
    // "Listar inscripciones a una mercancía"
    List<InscripcionTransporte> findByMercancia(Mercancia mercancia);
    
    // Ver inscripciones de un camión específico
    List<InscripcionTransporte> findByCamion(Camion camion);
}

