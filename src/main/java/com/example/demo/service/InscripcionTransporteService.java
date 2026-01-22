package com.example.demo.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.modelo.EstadoInscripcion;
import com.example.demo.modelo.InscripcionTransporte;
import com.example.demo.repository.InscripcionTransporteRepository;

@Service
public class InscripcionTransporteService {

    @Autowired
    private InscripcionTransporteRepository inscripcionRepo;


    // Crear inscripción (Conductores se apuntan)
    public InscripcionTransporte inscribirse(InscripcionTransporte inscripcion) {
        inscripcion.setEstado(EstadoInscripcion.PENDIENTE);
        inscripcion.setFechaInscripcion(LocalDateTime.now());
        return inscripcionRepo.save(inscripcion);
    }

    // Listar por mercancía (Para que la empresa vea quién se apuntó)
    public List<InscripcionTransporte> obtenerPorMercancia(String mercanciaId) {
        return inscripcionRepo.findByMercanciaId(mercanciaId);
    }

    // Obtener una por ID
    public InscripcionTransporte obtenerPorId(String id) {
        return inscripcionRepo.findById(id).orElse(null);
    }

    // Guardar/Actualizar (Para que la empresa ACEPTE o RECHACE)
    public InscripcionTransporte guardar(InscripcionTransporte i) {
        return inscripcionRepo.save(i);
    }

    // Borrar (Cancelar inscripción)
    public void borrar(String id) {
        inscripcionRepo.deleteById(id);
    }
}
