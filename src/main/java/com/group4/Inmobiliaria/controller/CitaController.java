package com.group4.Inmobiliaria.controller;

import com.group4.Inmobiliaria.entidades.*;
import com.group4.Inmobiliaria.enums.EstadoCita;
import com.group4.Inmobiliaria.enums.TipoProcedimiento;
import com.group4.Inmobiliaria.service.CitaService;
import com.group4.Inmobiliaria.service.PropiedadService;
import com.group4.Inmobiliaria.service.UserService;
import com.group4.Inmobiliaria.utils.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class CitaController {

    @Autowired
    CitaService citaService;

    @Autowired
    UserService userService;

    @Autowired
    PropiedadService propiedadService;



    @PostMapping("/crearCita")
    public String crearCita(Cita cita, @RequestParam("idPropiedad") String idPropiedad){
        Propiedad propiedad = propiedadService.encontrarById(idPropiedad);
        Usuario usuario = Session.getUserSession();
        Ente receptor = userService.obtenerEnteById(propiedad.getPropietario().getId());
        cita.setTipoProcedimiento(TipoProcedimiento.CITA);
        cita.setFechaEmision(new Date());
        cita.setHoraEmision(new Date());
        cita.setDescripcion("");
        cita.setEmisor((Cliente) usuario);
        cita.setReceptor(receptor);
        cita.setPropiedad(propiedad);
        cita.setEstado(EstadoCita.PENDIENTE);
        citaService.guardar(cita);
        return "redirect:/";
    }

    @PostMapping("/aceptarCita")
    public String aceptarCita(@RequestParam("citaId") String citaId){
        Cita cita = citaService.encontrarById(citaId);
        cita.setEstado(EstadoCita.ACEPTADA);
        citaService.guardar(cita);
        return "redirect:/vendedor";
    }

    @PostMapping("/rechazarCita")
    public String rechazarCita(@RequestParam("citaId") String citaId){
        Cita cita = citaService.encontrarById(citaId);
        cita.setEstado(EstadoCita.RECHAZADA);
        citaService.guardar(cita);
        return "redirect:/vendedor";
    }

}
