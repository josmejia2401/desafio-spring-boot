package com.josmejia2401.nuevospa.service.impl;

import com.josmejia2401.nuevospa.entity.Usuario;
import com.josmejia2401.nuevospa.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            Usuario usuario = usuarioRepository.findByUsername(username)
                    .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username));

            return User.builder()
                    .username(usuario.getUsername())
                    .password(usuario.getPassword())
                    .roles("USER")
                    .build();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new UsernameNotFoundException(ex.getMessage());
        }
    }
}

