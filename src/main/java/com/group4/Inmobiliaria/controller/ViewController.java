package com.group4.Inmobiliaria.controller;


import com.group4.Inmobiliaria.entidades.Propiedad;
import com.group4.Inmobiliaria.service.PropiedadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ViewController {

    @Autowired
    PropiedadService propiedadService;
    
    @GetMapping("/")
    public String index(Model model){
        List<Propiedad> propiedades = propiedadService.listarPropiedades();
        model.addAttribute("propiedades", propiedades);
        return "index";
    }
    
    @GetMapping("/propiedad/carga")
    public String cargarPropiedad(Propiedad propiedad){
        return "carga";
    }

    @PostMapping("/guardar")
    public String guardar(Propiedad propiedad){
        propiedadService.guardar(propiedad);
        return "redirect:/";
    }

    @GetMapping("/editar/{id}")
    public String editar(Propiedad propiedad, Model model){
        propiedad =propiedadService.encontrarById(propiedad);
        model.addAttribute("propiedad", propiedad);
        return "carga";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(Propiedad propiedad){
        propiedadService.eliminar(propiedad);
        return "redirect:/";
    }

    @GetMapping("/propiedades")
    public String listar(Model model){
        List<Propiedad> propiedades = propiedadService.listarPropiedades();
        model.addAttribute("propiedades", propiedades);
        return "propiedades";
    }

    @GetMapping("/nosotros")
    public String contacto(Model model){
        return "nosotros";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }
   //cambiar de archivo 
    @GetMapping("/administrador")
    public String admin(Model model){
        return "profile/administrador";
    }
    @GetMapping("/vendedor")
    public String vendedor(Model model){
        return "profile/vendedor";
    }
    @GetMapping("/inquilino")
    public String inquilino(Model model){
        return "profile/inquilino";
    }
    
    @RequestMapping("/404")
    public String handle404Error() {
        return "/404";
    }
}
