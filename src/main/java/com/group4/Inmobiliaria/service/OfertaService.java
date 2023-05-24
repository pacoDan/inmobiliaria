package com.group4.Inmobiliaria.service;

import com.group4.Inmobiliaria.entidades.Oferta;
import com.group4.Inmobiliaria.repository.OfertaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OfertaService {

    @Autowired
    OfertaRepository ofertaRepository;

    @Transactional
    public void guardar(Oferta oferta){
        ofertaRepository.save(oferta);
    }

    @Transactional
    public void eliminar(Oferta oferta){
        ofertaRepository.delete(oferta);
    }

    @Transactional
    public void eliminarById(String id){
        Oferta oferta = ofertaRepository.findById(id).orElse(null);
        if (oferta != null) {
            ofertaRepository.delete(oferta);
        }
    }

    @Transactional(readOnly = true)
    public Oferta encontrarById(String id){
        return ofertaRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<Oferta> listarOfertas(){
        return ofertaRepository.findAll();
    }

}
