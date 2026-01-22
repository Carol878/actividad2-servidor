package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.modelo.Mercancia;
import com.example.demo.service.MercanciasService;

@RestController
@RequestMapping("/api/mercancias") // La dirección base será http://localhost:8083/api/mercancias
public class MercanciaController {

    @Autowired
    private MercanciasService mercanciasService;

    @PostMapping
    public ResponseEntity<Mercancia> crearMercancia(@RequestBody Mercancia mercancia) {
        return ResponseEntity.ok(mercanciasService.guardarMercancia(mercancia));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mercancia> actualizar(@PathVariable String id, @RequestBody Mercancia mercancia) {
        Mercancia existente = mercanciasService.obtenerPorId(id);
        if (existente != null) {
            mercancia.setId(id);
            return ResponseEntity.ok(mercanciasService.guardarMercancia(mercancia));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Mercancia>> listarTodas() {
        return ResponseEntity.ok(mercanciasService.obtenerTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mercancia> obtenerPorId(@PathVariable String id) {
        Mercancia mercancia = mercanciasService.obtenerPorId(id);
        return (mercancia != null) ? ResponseEntity.ok(mercancia) : ResponseEntity.notFound().build();
    }

    @GetMapping("/pendientes")
    public ResponseEntity<List<Mercancia>> listarPendientes() {
        return ResponseEntity.ok(mercanciasService.obtenerDisponibles());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrar(@PathVariable String id) {
        mercanciasService.borrarMercancia(id);
        return ResponseEntity.noContent().build();
    }
}
