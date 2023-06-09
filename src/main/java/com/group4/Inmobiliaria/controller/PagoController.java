package com.group4.Inmobiliaria.controller;

import com.group4.Inmobiliaria.service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PagoController {

    @Autowired
    PagoService pagoService;

    @GetMapping("/crearPago")
    public String crearPago(){
        return "pago";
    }

}
