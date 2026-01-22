package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.modelo.EstadoMercancia;
import com.example.demo.modelo.Mercancia;
import com.example.demo.repository.MercanciaRepository;

@Service
public class MercanciasService {

    @Autowired
    private MercanciaRepository mercanciaRepository;

    // Crear o Actualizar
    public Mercancia guardarMercancia(Mercancia mercancia) {
        // Aquí podrías poner 'mercancia.setEstado(EstadoMercancia.PENDIENTE)' si es nueva
        return mercanciaRepository.save(mercancia);
    }

    // Leer todas
    public List<Mercancia> obtenerTodas() {
        return mercanciaRepository.findAll();
    }

    // Leer solo disponibles (para conductores)
    public List<Mercancia> obtenerDisponibles() {
        return mercanciaRepository.findByEstado(EstadoMercancia.PENDIENTE);
    }

    // Leer una por ID
    public Mercancia obtenerPorId(String id) {
        return mercanciaRepository.findById(id).orElse(null);
    }

    // Borrar
    public void borrarMercancia(String id) {
        mercanciaRepository.deleteById(id);
    }
}