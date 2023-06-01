package com.group4.Inmobiliaria.service;

import com.group4.Inmobiliaria.entidades.Consulta;
import com.group4.Inmobiliaria.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ConsultaService {

    @Autowired
    ConsultaRepository consultaRepository;

    @Transactional
    public void guardar(Consulta consulta){
        consultaRepository.save(consulta);
    }

    @Transactional
    public void eliminar(Consulta consulta){
        consultaRepository.delete(consulta);
    }

    @Transactional
    public void eliminarById(String id){
        Consulta consulta = consultaRepository.findById(id).orElse(null);
        if (consulta != null) {
            consultaRepository.delete(consulta);
        }
    }

    @Transactional(readOnly = true)
    public Consulta encontrarById(String id){
        return consultaRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<Consulta> listarConsultas(){
        return consultaRepository.findAll();
    }

}
