package com.group4.Inmobiliaria.controller;

import com.group4.Inmobiliaria.entidades.Propiedad;
import com.group4.Inmobiliaria.service.BusquedaPropiedadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BusquedaPropiedadController {
    @Autowired
    BusquedaPropiedadService propiedadService;

//    @GetMapping("/")
//    public String probando(Model model) {
//        System.out.println("probando--------------------");
//        this.mostrarPropiedades();
////        model.addAttribute("propiedades", propiedades);
//        return "index";
//    }

    private void mostrarPropiedades() {
        ArrayList<Propiedad> listaPropiedades = (ArrayList<Propiedad>) propiedadService.obtenerPropiedades();
        for (Propiedad propiedad : listaPropiedades) {
            System.out.println(propiedad.toString());
        }
    }

    public void someMethod() {
        System.out.println("CONTROLLER inicio ----------------------------------------------------------------------------------");
        ArrayList<Propiedad> listaPropiedades = (ArrayList<Propiedad>) propiedadService.obtenerPropiedades();

        for (Propiedad propiedad : listaPropiedades) {
            System.out.println(propiedad.toString());
        }
    }
}
