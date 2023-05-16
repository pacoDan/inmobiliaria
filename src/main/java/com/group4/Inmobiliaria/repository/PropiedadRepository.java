/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group4.Inmobiliaria.repository;

import com.group4.Inmobiliaria.entidades.Propiedad;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author PC - Escritorio
 */
public interface PropiedadRepository extends JpaRepository<Propiedad,String> {
    
}
