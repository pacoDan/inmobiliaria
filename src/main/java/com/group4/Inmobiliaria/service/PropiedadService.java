package com.group4.Inmobiliaria.service;

import com.group4.Inmobiliaria.entidades.Propiedad;
import com.group4.Inmobiliaria.excepciones.MiExcepcion;
import com.group4.Inmobiliaria.repository.PropiedadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PropiedadService {

    @Autowired
    PropiedadRepository propiedadRepository;

    @Transactional
    public void editar(Propiedad nuevaPropiedad) throws MiExcepcion {
        guardar(nuevaPropiedad);
//        propiedadRepository.save(nuevaPropiedad);
    }


    @Transactional
    public Propiedad guardar(Propiedad propiedad) throws MiExcepcion {
        validar(propiedad);
        return propiedadRepository.save(propiedad);
    }

    @Transactional
    public void eliminarById(String id) {
        Optional<Propiedad> propiedad = propiedadRepository.findById(id);
        if (propiedad.isPresent()) {
            propiedadRepository.delete(propiedad.get());
        }
    }

    @Transactional(readOnly = true)
    public Propiedad encontrarById(String id) {
        return propiedadRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<Propiedad> listarPropiedades() {
        return propiedadRepository.findAll();
    }

    private void validar(Propiedad propiedad) throws MiExcepcion {
        if (propiedad == null) {
            throw new MiExcepcion("La propiedad no puede ser nula.");
        }
        if( propiedad.getPrecioAlquiler()<1){
            throw new MiExcepcion("El precio de alquiler de la propiedad no puede ser nulo o menor a 1 o negativo.");
        }
        if (propiedad.getPropietario() == null) {
            throw new MiExcepcion("El propietario de la propiedad no puede ser nulo.");
        }
        if (propiedad.getCiudad() == null) {
            throw new MiExcepcion("El nombre de la ciudad no puede ser nula.");
        }     
        if(propiedad.getTipoPropiedad() == null){
            throw new MiExcepcion("El tipo de propiedad no puede ser nulo.");
        }
    }

}
