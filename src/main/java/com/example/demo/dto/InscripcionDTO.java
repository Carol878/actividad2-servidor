package com.example.demo.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class InscripcionDTO {
    private String id;
    private String matriculaCamion; // Solo nos interesa ver la matrícula, no todo el camión
    private String descripcionMercancia;
    private LocalDateTime fechaInscripcion;
    private String estado;
}
