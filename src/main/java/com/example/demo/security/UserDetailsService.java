package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Usuario;
import com.example.demo.repository.UsuarioRepository;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService { //para que no tenga el
                                                                                                        // mismo nombre
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Buscamos el usuario por email
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + email));

        // Convertimos a nuestro usuario de MongoDB a un UserDetails de Spring Security
        // El rol debe llevar el prefijo "ROLE_" para que Spring lo reconozca
        return User.builder()
                .username(usuario.getEmail())
                .password(usuario.getPassword())
                .roles(usuario.getRol().name()) // Spring añadirá "ROLE_" automáticamente aquí
                .build();
    }
}
