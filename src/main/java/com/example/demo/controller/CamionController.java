package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CamionDTO;
import com.example.demo.modelo.Camion;
import com.example.demo.service.CamionService;

@RestController
@RequestMapping("/api/camiones")
public class CamionController {

    @Autowired
    private CamionService camionService;

    @PostMapping
    @PreAuthorize("hasRole('CONDUCTOR')")
    public ResponseEntity<?> crearCamion(@RequestBody CamionDTO dto, Authentication auth) {
        try {
            Camion nuevo = camionService.crearCamion(dto, auth.getName());
            return ResponseEntity.ok(nuevo);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/mis-camiones")
    @PreAuthorize("hasRole('CONDUCTOR')")
    public ResponseEntity<List<Camion>> misCamiones(Authentication auth) {
        return ResponseEntity.ok(camionService.obtenerMisCamiones(auth.getName()));
    }
}
