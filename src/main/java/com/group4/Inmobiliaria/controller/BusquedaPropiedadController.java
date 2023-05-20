package com.group4.Inmobiliaria.controller;

import com.group4.Inmobiliaria.entidades.Propiedad;
import com.group4.Inmobiliaria.service.BusquedaPropiedadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class BusquedaPropiedadController {
    @Autowired
    BusquedaPropiedadService propiedadService;

    @GetMapping("/probando")
    public void probando() {
        ArrayList<Propiedad> listaPropiedades = (ArrayList<Propiedad>) propiedadService.obtenerPropiedades();

        for (Propiedad propiedad : listaPropiedades) {
            System.out.println(propiedad.toString());
        }
    }

    public void someMethod() {
        System.out.println("CONTROLLER----------------------------------------------------------------------------------");
        ArrayList<Propiedad> listaPropiedades = (ArrayList<Propiedad>) propiedadService.obtenerPropiedades();

        for (Propiedad propiedad : listaPropiedades) {
            System.out.println(propiedad.toString());
        }
    }
}
