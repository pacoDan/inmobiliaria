package com.group4.Inmobiliaria.service;

import com.group4.Inmobiliaria.controller.ContactoController;
import com.group4.Inmobiliaria.domain.Contacto;
import com.group4.Inmobiliaria.repository.RepositorioDeContactos;

public class ContactoService {


    ContactoController contactoRest;
    RepositorioDeContactos repo;

    public Contacto obtenerContacto(){
        //
     Contacto contacto = contactoRest.obtenerContacto();
        repo.crear(contacto);
        return contacto;
    }
}
