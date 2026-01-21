package com.example.demo.modelo;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import lombok.Data;

@Data
@Document(collection = "inscripciones")
public class InscripcionTransporte {

    @Id
    private String id;
    
    @DocumentReference
    private Camion camion;
    
    @DocumentReference
    private Mercancia mercancia;
    
    private LocalDateTime fechaInscripcion;
    private EstadoInscripcion estado; // PENDIENTE, ACEPTADA, RECHAZADA
}
