package com.example.demo.dto;

import com.example.demo.modelo.Rol;

import lombok.Data;

@Data
public class RegistroUsuarioDTO {
    private String nombre;
    private String email;
    private String password;
    private Rol rol; // El usuario elige si es EMPRESA o CONDUCTOR
}
