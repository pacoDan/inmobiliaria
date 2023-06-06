/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group4.Inmobiliaria.repository;

import com.group4.Inmobiliaria.entidades.ImagenPropiedad;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author PC - Escritorio
 */
@Repository
public interface ImagenPropiedadRepository extends JpaRepository<ImagenPropiedad, String>{
    
   
    public List<ImagenPropiedad> findByPropiedad_id(String id);
    
}
