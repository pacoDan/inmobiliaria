package com.group4.Inmobiliaria.repository;

import com.group4.Inmobiliaria.entidades.Cita;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitaRepository extends JpaRepository<Cita, String> {

    public List<Cita> findByEmisor_id(String id);

    public List<Cita> findByReceptor_id(String id);

}
