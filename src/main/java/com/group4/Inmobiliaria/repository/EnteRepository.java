/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group4.Inmobiliaria.repository;


import com.group4.Inmobiliaria.entidades.Ente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author PC - Escritorio
 */
public interface EnteRepository extends JpaRepository<Ente, String>{
    
    @Query("SELECT e FROM Ente e WHERE e.email = :email")
     public Ente findByEmail(@Param("email")String email);
    
}
