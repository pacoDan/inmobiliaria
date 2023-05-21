package com.group4.Inmobiliaria.service;

import com.group4.Inmobiliaria.entidades.Cliente;
import com.group4.Inmobiliaria.entidades.Ente;
import com.group4.Inmobiliaria.entidades.Usuario;
import com.group4.Inmobiliaria.enums.Rol;
import com.group4.Inmobiliaria.repository.ClienteRepository;
import com.group4.Inmobiliaria.repository.EnteRepository;
import com.group4.Inmobiliaria.repository.UsuarioRepository;
import com.group4.Inmobiliaria.utils.Session;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    EnteRepository enteRepository;
    
    @Autowired
    UsuarioRepository usuarioRepository;

    @Transactional
    public void registrarCliente(Cliente cliente) {

        cliente.setRol(Rol.CLIENTE);
        
        cliente.setFechaRegistro(new Date());

        cliente.setPassword(new BCryptPasswordEncoder().encode(cliente.getPassword()));

        clienteRepository.save(cliente);
    }

    @Transactional
    public void registrarEnte(Ente ente) {

        ente.setRol(Rol.ENTE);
        
        ente.setFechaRegistro(new Date());

        ente.setPassword(new BCryptPasswordEncoder().encode(ente.getPassword()));

        enteRepository.save(ente);

    }


    private User newSecurityUser(Usuario usuario) {
        List<GrantedAuthority> permisos = new ArrayList();
        GrantedAuthority p = new SimpleGrantedAuthority("ROLE_" + usuario.getRol());
        permisos.add(p);
        Session.setUserSession(usuario);
        return new User(usuario.getEmail(), usuario.getPassword(), permisos);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Usuario usuario = usuarioRepository.findByEmail(email);

        if (usuario != null) {           
            return newSecurityUser(usuario);
        }
        return null;
    }

}
