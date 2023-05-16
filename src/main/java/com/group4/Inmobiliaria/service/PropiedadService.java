package com.group4.Inmobiliaria.service;

import com.group4.Inmobiliaria.entidades.Propiedad;
import com.group4.Inmobiliaria.repository.PropiedadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PropiedadService {

    @Autowired
    PropiedadRepository propiedadRepository;

    @Transactional
    public void guardar(Propiedad propiedad){
        propiedadRepository.save(propiedad);
    }

    @Transactional
    public void eliminarById(String id){
        Optional<Propiedad> propiedad = propiedadRepository.findById(id);
        if (propiedad.isPresent()) {
            propiedadRepository.delete(propiedad.get());
        }
    }

}
