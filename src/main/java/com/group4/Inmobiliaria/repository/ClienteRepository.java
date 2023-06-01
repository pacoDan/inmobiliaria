/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group4.Inmobiliaria.repository;

import com.group4.Inmobiliaria.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author PC - Escritorio
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String>{
    
     @Query("SELECT c FROM Cliente c WHERE c.email = :email")
     public Cliente findByEmail(@Param("email")String email);
    
}
