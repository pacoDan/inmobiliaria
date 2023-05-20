package com.group4.Inmobiliaria.service;

import com.group4.Inmobiliaria.entidades.Propiedad;
import com.group4.Inmobiliaria.repository.PropiedadQueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusquedaPropiedadService {
    @Autowired
    private PropiedadQueryRepository repo;

    public List<Propiedad> obtenerPropiedades(){
        return repo.obtenerTodas();
    }
}
