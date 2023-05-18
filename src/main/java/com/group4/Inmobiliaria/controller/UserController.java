package com.group4.Inmobiliaria.controller;

import com.group4.Inmobiliaria.entidades.Cliente;
import com.group4.Inmobiliaria.entidades.Ente;
import com.group4.Inmobiliaria.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/registro")
    public String registro(){
        return "registro";
    }

    @GetMapping("/registro/cliente")
    public String registroCliente(Cliente cliente){
        return "registroCliente";
    }

    @GetMapping("/registro/ente")
    public String registroEnte(Ente ente){
        return "registroCliente";
    }

    @PostMapping("/guardar/cliente")
    public String guardarCliente(Cliente cliente){
        userService.registrarCliente(cliente);
        return "redirect:/";
    }

    @PostMapping("/guardar/ente")
    public String guardarEnte(Ente ente){
        userService.registrarEnte(ente);
        return "redirect:/";
    }

}
