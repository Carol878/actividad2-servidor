package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.modelo.EstadoMercancia;
import com.example.demo.modelo.Mercancia;

public interface MercanciaRepository extends MongoRepository<Mercancia, String> {
    
    // "Obtener todas las mercancías disponibles (pendientes)"
    List<Mercancia> findByEstado(EstadoMercancia estado);
    
    // "Buscar mercancías por origen, destino..."
    List<Mercancia> findByOrigen(String origen);
    List<Mercancia> findByDestino(String destino);
    
    // Buscar por peso máximo (menor o igual que)
    List<Mercancia> findByPesoKgLessThanEqual(Double pesoMaximo);
}
