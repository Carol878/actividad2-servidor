package com.example.demo.service;

import com.example.demo.dto.RegistroUsuarioDTO;
import com.example.demo.modelo.Usuario;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

   // @Autowired
   // private PasswordEncoder passwordEncoder;

    public Usuario registrarUsuario(RegistroUsuarioDTO dto) {
        // Validamos si el email ya existe
        if (usuarioRepository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("El email ya está registrado");
        }

        Usuario usuario = new Usuario();
        usuario.setNombre(dto.getNombre());
        usuario.setEmail(dto.getEmail());
        usuario.setRol(dto.getRol());

        // Encriptamos la contraseña antes de guardar
        /*usuario.setPassword(passwordEncoder.encode(dto.getPassword()));*/

        return usuarioRepository.save(usuario);
    }
}
