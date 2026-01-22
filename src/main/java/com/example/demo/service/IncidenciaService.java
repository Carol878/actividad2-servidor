package com.example.demo.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.modelo.Incidencia;
import com.example.demo.repository.IncidenciaRepository;

@Service
public class IncidenciaService {

    @Autowired
    private IncidenciaRepository incidenciaRepo;

    // Crear reporte
    public Incidencia reportar(Incidencia incidencia) {
        if (incidencia.getFecha() == null) {
            incidencia.setFecha(LocalDateTime.now());
        }
        if (incidencia.getEstado() == null) {
            incidencia.setEstado("ABIERTA");
        }
        return incidenciaRepo.save(incidencia);
    }

    // Listar todas
    public List<Incidencia> listarTodas() {
        return incidenciaRepo.findAll();
    }

    // Ver una por ID
    public Incidencia obtenerPorId(String id) {
        return incidenciaRepo.findById(id).orElse(null);
    }

    // Borrar
    public void borrar(String id) {
        incidenciaRepo.deleteById(id);
    }
}
