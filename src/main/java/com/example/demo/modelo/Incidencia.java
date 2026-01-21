package com.example.demo.modelo;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import lombok.Data;

@Data
@Document(collection = "incidencias")
public class Incidencia {

    @Id
    private String id;
    
    @DocumentReference
    private Camion camion;
    
    private String descripcion;
    private LocalDateTime fecha;
    private String tipo; // mecanica, meteorologica, documental
    private String estado; // abierta, resuelta
}
