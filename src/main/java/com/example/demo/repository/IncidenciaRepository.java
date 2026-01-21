package com.example.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.modelo.Camion;
import com.example.demo.modelo.Incidencia;

public interface IncidenciaRepository extends MongoRepository<Incidencia, String> {
    
    List<Incidencia> findByCamion(Camion camion);
    
    // "Incidencias registradas en el último mes"
    // Spring Data permite buscar por fechas con 'After' o 'Between'
    List<Incidencia> findByCamionAndFechaAfter(Camion camion, LocalDateTime fechaInicio);
}

