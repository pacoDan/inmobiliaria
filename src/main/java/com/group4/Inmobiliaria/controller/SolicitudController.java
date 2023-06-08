package com.group4.Inmobiliaria.controller;

import com.group4.Inmobiliaria.entidades.Cliente;
import com.group4.Inmobiliaria.entidades.Solicitud;
import com.group4.Inmobiliaria.enums.EstadoSolicitud;
import com.group4.Inmobiliaria.enums.TipoProcedimiento;
import com.group4.Inmobiliaria.enums.TipoSolicitud;
import com.group4.Inmobiliaria.service.SolicitudService;
import com.group4.Inmobiliaria.utils.Session;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/solicitud")
public class SolicitudController {

    @Autowired
    SolicitudService solicitudService;

    @PostMapping("/guardar/compra")
    public String guardarSolicitudCompra(Solicitud solicitud) {
        Cliente cliente = (Cliente) Session.getUserSession();
        
        solicitud.setTipoProcedimiento(TipoProcedimiento.SOLICITUD);
        solicitud.setTipoSolicitud(TipoSolicitud.COMPRA);
        solicitud.setEstadoSolicitud(EstadoSolicitud.PENDIENTE);

        solicitud.setFechaEmision(new Date());
        solicitud.setHoraEmision(new Date());
        
        solicitud.setEmisor(cliente);

        solicitudService.guardarSolicitud(solicitud);

        return "redirect:/inquilino";
    }

    @PostMapping("/guardar/alquiler")
    public String guardarSolicitudAlquiler(Solicitud solicitud) {
        Cliente cliente = (Cliente) Session.getUserSession();

        solicitud.setTipoProcedimiento(TipoProcedimiento.SOLICITUD);
        solicitud.setTipoSolicitud(TipoSolicitud.ALQUILER);
        solicitud.setEstadoSolicitud(EstadoSolicitud.PENDIENTE);

        solicitud.setFechaEmision(new Date());
        solicitud.setHoraEmision(new Date());
        
        solicitud.setEmisor(cliente);
        
        solicitudService.guardarSolicitud(solicitud);

        return "redirect:/inquilino";
    }

}
