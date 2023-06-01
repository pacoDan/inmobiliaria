package com.group4.Inmobiliaria.service;

import com.group4.Inmobiliaria.entidades.Pago;
import com.group4.Inmobiliaria.repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PagoService {

    @Autowired
    PagoRepository pagoRepository;

    @Transactional
    public void guardar(Pago pago){
        pagoRepository.save(pago);
    }

    @Transactional
    public void eliminar(Pago pago){
        pagoRepository.delete(pago);
    }

    @Transactional
    public void eliminarById(String id){
        Pago pago = pagoRepository.findById(id).orElse(null);
        if (pago != null) {
            pagoRepository.delete(pago);
        }
    }

    @Transactional(readOnly = true)
    public Pago encontrarById(String id){
        return pagoRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<Pago> listarPagos(){
        return pagoRepository.findAll();
    }

}
