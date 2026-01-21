package com.example.demo.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import lombok.Data;

@Data
@Document(collection = "camiones")
public class Camion {

    @Id
    private String id;
    
    // Relación: Un camión pertenece a un conductor (Usuario)
    // lazy = true significa que no traerá los datos del usuario hasta que se pidan explícitamente
    @DocumentReference(lazy = true) 
    private Usuario conductor;

    private String matricula;
    private String modelo;
    private Double capacidadKg;
    private EstadoCamion estado;
}
