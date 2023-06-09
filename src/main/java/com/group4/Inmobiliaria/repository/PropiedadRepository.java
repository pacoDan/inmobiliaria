/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group4.Inmobiliaria.repository;

import com.group4.Inmobiliaria.entidades.Propiedad;
import java.util.List;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author PC - Escritorio
 */
@Repository
public interface PropiedadRepository extends JpaRepository<Propiedad,String> {
    
    public Propiedad findByInquilino_id(String id);
    
    @EntityGraph(attributePaths = "imagenes")
    @Query("SELECT DISTINCT p FROM Propiedad p LEFT JOIN FETCH p.imagenes")
    public List<Propiedad> findAllWithImages();
    
}
