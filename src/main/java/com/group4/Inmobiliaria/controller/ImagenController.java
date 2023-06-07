package com.group4.Inmobiliaria.controller;

import com.group4.Inmobiliaria.entidades.ImagenPropiedad;
import com.group4.Inmobiliaria.service.ImagenService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/imagen")
public class ImagenController {
    
    @Autowired
    ImagenService imagenService;
    
    @GetMapping("/propiedad/{id}")
    public List<ImagenPropiedad> findImagesByPropiedadId(@PathVariable("id") String id){
        return imagenService.findImagesByPropiedadId(id);
    }
    
    @GetMapping("/{id}")
    public ImagenPropiedad findById(@PathVariable("id") String id){
        return imagenService.findById(id);
    }
    
}
