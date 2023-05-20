package com.group4.Inmobiliaria.controller;


import com.group4.Inmobiliaria.entidades.Propiedad;
import com.group4.Inmobiliaria.service.BusquedaPropiedadService;
import com.group4.Inmobiliaria.service.PropiedadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;


@Controller
public class ViewController {

    @Autowired
    PropiedadService propiedadService;
    @Autowired
    BusquedaPropiedadService busqueda;

    //    @GetMapping("/")
//    public String index(Model model, @RequestParam(required = false) String query){
//        List<Propiedad> propiedades = propiedadService.listarPropiedades();
//        model.addAttribute("propiedades", propiedades);
//        if (query != null) {
//            // Realiza acciones con el valor de búsqueda
//            System.out.println("Valor de búsqueda: " + query+"*******************");
//            // Otra lógica de procesamiento de búsqueda
//            busqueda.imprimirContenidoDeBuscador();
//        }
//        return "index";
//    }
    @GetMapping("/")
    public String index(Model model) {
        List<Propiedad> propiedades = propiedadService.listarPropiedades();
        List<String> tiposPropiedad = Arrays.asList("Casa", "Departamento", "Terreno", "Local comercial");
        model.addAttribute("propiedades", propiedades);
        model.addAttribute("tiposPropiedad", tiposPropiedad);
        return "index";
    }


    @GetMapping("/propiedad/carga")
    public String cargarPropiedad(Propiedad propiedad) {
        return "carga";
    }

    @PostMapping("/guardar")
    public String guardar(Propiedad propiedad) {
        propiedadService.guardar(propiedad);
        return "redirect:/";
    }

    @GetMapping("/editar/{id}")
    public String editar(Propiedad propiedad, Model model) {
        propiedad = propiedadService.encontrarById(propiedad);
        model.addAttribute("propiedad", propiedad);
        return "carga";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(Propiedad propiedad) {
        propiedadService.eliminar(propiedad);
        return "redirect:/";
    }

    @GetMapping("/propiedades")
    public String listar(Model model) {
        List<Propiedad> propiedades = propiedadService.listarPropiedades();
        model.addAttribute("propiedades", propiedades);
        return "propiedades";
    }
}
