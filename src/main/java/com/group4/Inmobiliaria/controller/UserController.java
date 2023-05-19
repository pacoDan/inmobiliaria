package com.group4.Inmobiliaria.controller;

import com.group4.Inmobiliaria.entidades.Cliente;
import com.group4.Inmobiliaria.entidades.Ente;
import com.group4.Inmobiliaria.enums.TipoCliente;
import com.group4.Inmobiliaria.enums.TipoEnte;
import com.group4.Inmobiliaria.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/registro")
    public String registro(){
        return "eleccionRegister";
    }

    @GetMapping("/registro/comprador")
    public String registroComprador(Cliente cliente, Model model){
        cliente.setTipoCliente(TipoCliente.COMPRADOR);
        model.addAttribute("cliente", cliente);
        return "registerComprador";
    }

    @GetMapping("/registro/inquilino")
    public String registroInquilino(Cliente cliente, Model model){
        cliente.setTipoCliente(TipoCliente.INQUILINO);
        model.addAttribute("cliente", cliente);
        return "registerInquilino";
    }

    @GetMapping("/registro/propietario")
    public String registroPropietario(Ente ente, Model model){
        ente.setTipoEnte(TipoEnte.PROPIETARIO);
        model.addAttribute("ente", ente);
        return "registerPropietario";
    }

    @GetMapping("/registro/inmobiliaria")
    public String registroInmobiliaria(Ente ente, Model model){
        ente.setTipoEnte(TipoEnte.INMOBILIARIA);
        model.addAttribute("ente", ente);
        return "registerInmobiliaria";
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
