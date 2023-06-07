package com.group4.Inmobiliaria.controller;

import com.group4.Inmobiliaria.entidades.*;
import com.group4.Inmobiliaria.enums.EstadoOferta;
import com.group4.Inmobiliaria.enums.TipoProcedimiento;
import com.group4.Inmobiliaria.service.OfertaService;
import com.group4.Inmobiliaria.service.PropiedadService;
import com.group4.Inmobiliaria.service.UserService;
import com.group4.Inmobiliaria.service.UsuarioService;
import com.group4.Inmobiliaria.utils.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class OfertaController {

    @Autowired
    OfertaService ofertaService;

    @Autowired
    PropiedadService propiedadService;

    @Autowired
    UserService userService;

    @GetMapping("/crearOferta")
    public String crearOfertao(@RequestParam("idPropiedad") String idPropiedad, Model model){
        Propiedad propiedad = propiedadService.encontrarById(idPropiedad);
        model.addAttribute("propiedad", propiedad);
        return "ofertas";
    }

    @PostMapping("/crearOferta")
    public String ofertar(Oferta oferta, @RequestParam("idPropiedad") String idPropiedad){
        Propiedad propiedad = propiedadService.encontrarById(idPropiedad);
        Usuario usuario = Session.getUserSession();
        Ente receptor = userService.obtenerEnteById(propiedad.getPropietario().getId());
        oferta.setEstado(EstadoOferta.PENDIENTE);
        oferta.setTipoProcedimiento(TipoProcedimiento.OFERTA);
        oferta.setFechaEmision(new Date());
        oferta.setHoraEmision(new Date());
        oferta.setDescripcion("");
        oferta.setEmisor((Cliente) usuario);
        oferta.setReceptor(receptor);
        oferta.setPropiedad(propiedad);
        ofertaService.guardar(oferta);
        return "redirect:/";
    }

}
