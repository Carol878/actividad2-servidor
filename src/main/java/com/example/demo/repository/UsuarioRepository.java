package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.modelo.Rol;
import com.example.demo.modelo.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
    
    // Metodo mágico: Spring sabe buscar por email automáticamente solo viendo el nombre
    Optional<Usuario> findByEmail(String email);
    
    // Para listar usuarios por rol (ej. ver todos los conductores)
    List<Usuario> findByRol(Rol rol);
    
    // Verifica si existe (útil para el registro)
    boolean existsByEmail(String email);
}
