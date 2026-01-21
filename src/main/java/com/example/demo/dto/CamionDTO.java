package com.example.demo.dto;

import lombok.Data;

@Data
public class CamionDTO {
    private String matricula;
    private String modelo;
    private Double capacidadKg;
    // No pedimos el objeto Usuario completo, ni el estado (se pondrá activo por defecto)
}