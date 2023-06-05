package com.group4.Inmobiliaria.controller;

import com.group4.Inmobiliaria.entidades.Propiedad;
import com.group4.Inmobiliaria.entidades.Usuario;
import com.group4.Inmobiliaria.service.ImagenService;
import com.group4.Inmobiliaria.service.PropiedadService;
import java.util.List;

import com.group4.Inmobiliaria.utils.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/propiedad")
@Controller
public class PropiedadController {

    @Autowired
    PropiedadService propiedadService;
    
    @Autowired
    ImagenService imagenService;

    @GetMapping("/carga")
    public String cargarPropiedad(Propiedad propiedad, Model model) {
        Usuario propietario = ((Usuario) Session.getUserSession());

        propiedad.setPropietario(propietario);

        model.addAttribute("propiedad", propiedad);
        return "carga";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Propiedad propiedad) throws Exception {
        
        List<MultipartFile> imagenesFiles = propiedad.getImagenesFiles();
        
        Propiedad propiedadSaved = propiedadService.guardar(propiedad);
        
        imagenService.guardarImagenesPropiedad(imagenesFiles, propiedadSaved);
        
        return "redirect:/";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") String id, Model model) {
        Propiedad propiedad = propiedadService.encontrarById(id);
        model.addAttribute("propiedad", propiedad);
        return "carga";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") String id) {
        propiedadService.eliminarById(id);
        return "redirect:/";
    }

    @GetMapping("/all")
    public String listar(Model model) {
        List<Propiedad> propiedades = propiedadService.listarPropiedades();
        model.addAttribute("propiedades", propiedades);
        return "propiedades";
    }

}
