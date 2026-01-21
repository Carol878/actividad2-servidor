package com.example.demo.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data // Lombok genera getters, setters, toString, etc. automáticamente
@Document(collection = "usuarios")
public class Usuario {
    
    @Id
    private String id;
    
    private String nombre;
    private String email;
    private String password; // Recuerda que luego la encriptaremos
    private Rol rol; // EMPRESA o CONDUCTOR
}
