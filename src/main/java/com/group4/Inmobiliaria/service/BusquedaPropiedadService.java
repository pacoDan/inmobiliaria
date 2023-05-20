package com.group4.Inmobiliaria.service;

import com.group4.Inmobiliaria.entidades.Propiedad;
import com.group4.Inmobiliaria.repository.PropiedadQueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BusquedaPropiedadService {
    @Autowired
    private PropiedadQueryRepository repo;

    public List<Propiedad> obtenerPropiedades(){
        return repo.obtenerTodas();
    }

	public void mostrarPropiedades() {
		System.out.println("mostrarPropiedades()-------------------");
        ArrayList<Propiedad> listaPropiedades = (ArrayList<Propiedad>) this.obtenerPropiedades();
        for (Propiedad propiedad : listaPropiedades) {
            System.out.println(propiedad.toString());
        }
	}

	public void imprimirContenidoDeBuscador() {
		System.out.println("imprimirContenidoDeBuscador()");
	}

    public List<Propiedad> buscarPropiedades(String tipoPropiedad, String query) {
        //TODO: luego implementar la busqueda
        return repo.obtenerTodas();
    }
}
