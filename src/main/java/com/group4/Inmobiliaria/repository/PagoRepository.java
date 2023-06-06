package com.group4.Inmobiliaria.repository;

import com.group4.Inmobiliaria.entidades.Pago;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagoRepository extends JpaRepository<Pago, String> {
    
    public List<Pago>findByEmisor_id(String id);
    
    public List<Pago>findByReceptor_id(String id);
    
}
