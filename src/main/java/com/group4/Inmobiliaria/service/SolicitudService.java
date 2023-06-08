package com.group4.Inmobiliaria.service;

import com.group4.Inmobiliaria.entidades.Solicitud;
import com.group4.Inmobiliaria.repository.SolicitudRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SolicitudService {

    @Autowired
    SolicitudRepository solicitudRepository;

    public void guardarSolicitud(Solicitud solicitud) {        
        solicitudRepository.save(solicitud);
    }
    
    public List<Solicitud>findByEmisorId(String id){
        return solicitudRepository.findByEmisor_id(id);
    }
    
    public List<Solicitud>findByReceptorId(String id){
        return solicitudRepository.findByReceptor_id(id);
    }

}
