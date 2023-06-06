package com.group4.Inmobiliaria.repository;

import com.group4.Inmobiliaria.entidades.Reclamo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReclamoRepository extends JpaRepository<Reclamo, String> {
    
    public List<Reclamo>findByEmisor_id(String id);
    
    public List<Reclamo>findByReceptor_id(String id);
    
}
