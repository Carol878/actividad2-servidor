package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.modelo.Incidencia;

public class IncidenciaController {

    @GetMapping("/{id}")
    public ResponseEntity<Incidencia> obtenerPorId(@PathVariable String id) {
        // Necesitas añadir 'obtenerPorId' en tu Servicio de Incidencias
        // return ResponseEntity.ok(incidenciaService.obtenerPorId(id));
        return null; // Cambia esto cuando actualices el servicio
    }

    @PutMapping("/{id}")
    public ResponseEntity<Incidencia> actualizar(@PathVariable String id, @RequestBody Incidencia incidencia) {
        incidencia.setId(id);
        return ResponseEntity.ok(incidenciaService.reportar(incidencia)); // Reusamos guardar
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrar(@PathVariable String id) {
        incidenciaService.borrar(id);
        return ResponseEntity.noContent().build();
    }

}

