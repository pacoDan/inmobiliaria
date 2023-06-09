package com.group4.Inmobiliaria.service;

import com.group4.Inmobiliaria.entidades.Reclamo;
import com.group4.Inmobiliaria.enums.EstadoReclamo;
import com.group4.Inmobiliaria.repository.ReclamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReclamoService {

    @Autowired
    ReclamoRepository reclamoRepository;

    @Transactional
    public void guardar(Reclamo reclamo){        
        reclamoRepository.save(reclamo);
    }

    @Transactional
    public void eliminar(Reclamo reclamo){
        reclamoRepository.delete(reclamo);
    }

    @Transactional
    public void eliminarById(String id){
        Reclamo reclamo = reclamoRepository.findById(id).orElse(null);
        if (reclamo != null) {
            reclamoRepository.delete(reclamo);
        }
    }

    @Transactional(readOnly = true)
    public Reclamo encontrarById(String id){
        return reclamoRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<Reclamo> listarReclamos(){
        return reclamoRepository.findAll();
    }
    
    public List<Reclamo>findByEmisorId(String id){
        return reclamoRepository.findByEmisor_id(id);
    }
    
     public List<Reclamo>findByReceptorId(String id){
        return reclamoRepository.findByReceptor_id(id);
    }

}
