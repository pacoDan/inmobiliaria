package com.group4.Inmobiliaria.repository;

import com.group4.Inmobiliaria.entidades.Propiedad;
import com.group4.Inmobiliaria.repository.crud.PropiedadRepositoryCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PropiedadQueryRepository {
    @Autowired
    private PropiedadRepositoryCRUD repoCrud;

    public List<Propiedad> obtenerTodas(){
        return this.repoCrud.findAll();
    }
}
