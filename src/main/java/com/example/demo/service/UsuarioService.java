package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.demo.dto.RegistroUsuarioDTO;
import com.example.demo.modelo.Rol;
import com.example.demo.modelo.Usuario;
import com.example.demo.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired // Descomenta esto para que funcione la encriptación
    private PasswordEncoder passwordEncoder;

    public Usuario registrarUsuario(RegistroUsuarioDTO dto) {
        if (usuarioRepository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("El email ya está registrado");
        }
        Usuario usuario = new Usuario();
        usuario.setNombre(dto.getNombre());
        usuario.setEmail(dto.getEmail());
        usuario.setRol(dto.getRol());
        usuario.setPassword(passwordEncoder.encode(dto.getPassword())); // Descomenta esto
        return usuarioRepository.save(usuario);
    }

    // --- MÉTODOS QUE FALTABAN PARA EL CRUD ---

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public Usuario obtenerPorId(String id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public void borrarUsuario(String id) {
        usuarioRepository.deleteById(id);
    }

    // Método extra para actualizar (reutilizamos save)
    public Usuario guardar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
}
