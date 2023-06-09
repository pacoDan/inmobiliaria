package com.group4.Inmobiliaria.service;

import com.group4.Inmobiliaria.entidades.Cita;
import com.group4.Inmobiliaria.repository.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CitaService {

    @Autowired
    CitaRepository citaRepository;

    @Transactional
    public void guardar(Cita cita) {
        citaRepository.save(cita);
    }

    @Transactional
    public void eliminar(Cita cita) {
        citaRepository.delete(cita);
    }

    @Transactional
    public void eliminarById(String id) {
        Cita cita = citaRepository.findById(id).orElse(null);
        if (cita != null) {
            citaRepository.delete(cita);
        }
    }

    @Transactional(readOnly = true)
    public Cita encontrarById(String id) {
        return citaRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<Cita> listarCitas() {
        return citaRepository.findAll();
    }

    public List<Cita> findByEmisorId(String id) {
        return citaRepository.findByEmisor_id(id);
    }

    public List<Cita> findByReceptorId(String id) {
        return citaRepository.findByReceptor_id(id);
    }
}
