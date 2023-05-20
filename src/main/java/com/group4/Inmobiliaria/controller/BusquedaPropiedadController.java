package com.group4.Inmobiliaria.controller;

import com.group4.Inmobiliaria.entidades.Propiedad;
import com.group4.Inmobiliaria.service.BusquedaPropiedadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BusquedaPropiedadController {
    @Autowired
    BusquedaPropiedadService propiedadService;

    @GetMapping("/probando")
    public String probando(Model model) {
        System.out.println("probando--------------------");
//        model.addAttribute("propiedades", propiedades);
        propiedadService.mostrarPropiedades();
        return "index";
    }

//    @PostMapping("/buscar")
//    public ResponseEntity<?> buscar(@RequestParam("query") String query) {
//        // Procesa la búsqueda y devuelve una respuesta adecuada
//        System.out.println("Valor de búsqueda: " + query);
//        // Otra lógica de procesamiento de búsqueda
//        
//        // Devuelve una respuesta adecuada según tus necesidades
//        return ResponseEntity.ok().build();
//    }
    @PostMapping("/buscar")
    public String buscar(@RequestParam("query") String query, Model model ) {
        // Procesa la búsqueda y realiza la lógica necesaria
    	System.out.println("/BUSCAR!!!!!");
        System.out.println("Valor de búsqueda: " + query);
        // Otra lógica de procesamiento de búsqueda
        
        // Redirige de vuelta al index.html
        return "redirect:/";
    }
}
