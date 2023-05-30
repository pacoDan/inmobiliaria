package com.group4.Inmobiliaria.service;


import com.group4.Inmobiliaria.entidades.Procedimiento;
import com.group4.Inmobiliaria.repository.ProcedimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProcedimientoService {

    @Autowired
    ProcedimientoRepository procedimientoRepository;

    @Transactional
    public List<Procedimiento> getAllProcedimientos(){
        return procedimientoRepository.findAll();
    }


}
