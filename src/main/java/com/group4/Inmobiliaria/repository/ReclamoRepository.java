package com.group4.Inmobiliaria.repository;

import com.group4.Inmobiliaria.entidades.Reclamo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReclamoRepository extends JpaRepository<Reclamo, String> {
    
    List<Reclamo>findByCliente_id(String id);
    
    List<Reclamo>findByEnte_id(String id);
    
}
