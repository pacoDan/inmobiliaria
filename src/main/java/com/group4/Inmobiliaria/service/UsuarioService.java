package com.group4.Inmobiliaria.service;

import com.group4.Inmobiliaria.entidades.Usuario;
import com.group4.Inmobiliaria.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public List<Usuario> getAllUsers() {
        return usuarioRepository.findAll();
    }

}
