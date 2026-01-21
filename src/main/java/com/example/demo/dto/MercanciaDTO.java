package com.example.demo.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class MercanciaDTO {
    private String descripcion;
    private String origen;
    private String destino;
    private Double pesoKg;
    private LocalDate fechaEntregaEstimada;
}
