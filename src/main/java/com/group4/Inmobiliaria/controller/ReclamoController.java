package com.group4.Inmobiliaria.controller;

import com.group4.Inmobiliaria.entidades.Cliente;
import com.group4.Inmobiliaria.entidades.Ente;
import com.group4.Inmobiliaria.entidades.Propiedad;
import com.group4.Inmobiliaria.entidades.Reclamo;
import com.group4.Inmobiliaria.enums.EstadoReclamo;
import com.group4.Inmobiliaria.enums.TipoProcedimiento;
import com.group4.Inmobiliaria.service.PropiedadService;
import com.group4.Inmobiliaria.service.ReclamoService;
import com.group4.Inmobiliaria.utils.Session;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reclamo")
public class ReclamoController {

    @Autowired
    ReclamoService reclamoService;
    
    @Autowired 
    PropiedadService propiedadService;
    
    @PostMapping("/guardar")
    public String guardarReclamo(Reclamo reclamo){
        Cliente cliente = (Cliente) Session.getUserSession();                
        
        Propiedad propiedad = propiedadService.findByInquilinoId(cliente.getId());                
        
        reclamo.setFechaEmision(new Date());
        reclamo.setHoraEmision(new Date());
        
        reclamo.setEmisor(cliente);
        reclamo.setReceptor(propiedad.getPropietario());
        
        reclamo.setPropiedad(propiedad);
        reclamo.setEstadoReclamo(EstadoReclamo.PENDIENTE);
        
        reclamo.setTipoProcedimiento(TipoProcedimiento.RECLAMO);
        
        reclamoService.guardar(reclamo);
        
        return "redirect:/inquilino";
    }

}
