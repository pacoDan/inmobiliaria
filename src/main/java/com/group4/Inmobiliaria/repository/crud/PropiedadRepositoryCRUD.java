package com.group4.Inmobiliaria.repository.crud;


import com.group4.Inmobiliaria.entidades.Propiedad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropiedadRepositoryCRUD  extends JpaRepository<Propiedad,String> {
}
