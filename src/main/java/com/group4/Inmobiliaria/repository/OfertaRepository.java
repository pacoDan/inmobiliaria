package com.group4.Inmobiliaria.repository;

import com.group4.Inmobiliaria.entidades.Oferta;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfertaRepository extends JpaRepository<Oferta, String> {
    
    public List<Oferta>findByEmisor_id(String id);
    
    public List<Oferta>findByReceptor_id(String id);
    
}
