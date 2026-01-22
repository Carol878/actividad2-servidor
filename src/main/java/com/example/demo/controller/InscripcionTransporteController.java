package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.modelo.InscripcionTransporte;

public class InscriocionTransporteController {


    @GetMapping("/{id}")
    public ResponseEntity<InscripcionTransporte> obtenerPorId(@PathVariable String id) {
        InscripcionTransporte inscripcion = inscripcionService.obtenerPorId(id);
        return (inscripcion != null) ? ResponseEntity.ok(inscripcion) : ResponseEntity.notFound().build();
    }


    // (Necesitarás añadir el método 'borrar' en tu Servicio primero)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrar(@PathVariable String id) {
        // Asegúrate de añadir 'public void borrar(String id) { inscripcionRepo.deleteById(id); }' en tu Service
        inscripcionService.borrar(id);
        return ResponseEntity.noContent().build();
    }

}
