package com.group4.Inmobiliaria.controller;

import com.group4.Inmobiliaria.entidades.Propiedad;
import com.group4.Inmobiliaria.service.PropiedadService;
import com.group4.Inmobiliaria.utils.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class ViewController {

    @Autowired
    PropiedadService propiedadService;

    @GetMapping("/")
    public String index(Model model) {
        List<Propiedad> propiedades = propiedadService.listarPropiedades();
        model.addAttribute("propiedades", propiedades);     
        
        System.out.println(Session.getUserSession());
        
        return "index";
    }

    @GetMapping("/nosotros")
    public String contacto(Model model) {

        return "nosotros";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
