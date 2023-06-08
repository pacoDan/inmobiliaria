package com.group4.Inmobiliaria.controller;

import com.group4.Inmobiliaria.entidades.Cita;
import com.group4.Inmobiliaria.entidades.Propiedad;
import com.group4.Inmobiliaria.entidades.Reclamo;
import com.group4.Inmobiliaria.service.ReclamoService;
import com.group4.Inmobiliaria.entidades.Oferta;
import com.group4.Inmobiliaria.entidades.Solicitud;
import com.group4.Inmobiliaria.entidades.Usuario;
import com.group4.Inmobiliaria.service.CitaService;
import com.group4.Inmobiliaria.service.OfertaService;
import com.group4.Inmobiliaria.service.PropiedadService;
import com.group4.Inmobiliaria.service.SolicitudService;
import com.group4.Inmobiliaria.service.UsuarioService;
import com.group4.Inmobiliaria.utils.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class ViewController {

    @Autowired
    PropiedadService propiedadService;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    CitaService citaService;

    @Autowired
    ReclamoService reclamoService;

    @Autowired
    OfertaService ofertaService;
    
    @Autowired
    SolicitudService solicitudService;

    @GetMapping("/")
    public String index(Model model) {

        List<Propiedad> propiedades = propiedadService.findAlldWithImages();
        model.addAttribute("propiedades", propiedades);

        Usuario logged = Session.getUserSession();

        System.out.println(logged);                       

        if (logged != null && logged.getRol().toString().equals("ADMIN")) {
            return "redirect:/admin";
        }

        return "index";
    }

    @GetMapping("/contacto")
    public String contacto(Model model) {

        return "contacto";
    }

    @GetMapping("/nosotros")
    public String nosotros(Model model) {

        return "sobreNosotros";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    /*
    @GetMapping("/propiedad")
    public String propiedad() {
        return "propiedad";
    }*/
    @GetMapping("/reuniones")
    public String reuniones(Model model) {

        return "reuniones";
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        List<Usuario> usuarios = usuarioService.getAllUsers();
        model.addAttribute("usuarios", usuarios);

        List<Propiedad> propiedades = propiedadService.listarPropiedades();
        model.addAttribute("propiedades", propiedades);

        return "profile/administrador";
    }

    @GetMapping("/vendedor")
    public String vendedor(Model model) {
        List<Propiedad> propiedades = propiedadService.findAlldWithImages();
        model.addAttribute("propiedades", propiedades);
        
        List<Reclamo> reclamos = reclamoService.findByReceptorId(Session.getUserSession().getId());                
        model.addAttribute("reclamos", reclamos);       

        Usuario usuario = Session.getUserSession();
        model.addAttribute("usuario", usuario);

        List<Cita> citas = citaService.findByReceptorId(usuario.getId());
        model.addAttribute("citas", citas);

        List<Oferta> ofertas = ofertaService.findByReceptorId(usuario.getId());
        model.addAttribute("ofertas", ofertas);
        
        List<Solicitud> solicitudes = solicitudService.findByReceptorId(Session.getUserSession().getId());
        model.addAttribute("solicitudes", solicitudes);

        return "profile/vendedor";
    }

    @GetMapping("/inquilino")

    public String inquilino(Model model){

        Usuario usuario = Session.getUserSession();

        List <Reclamo> reclamos = reclamoService.findByEmisorId(Session.getUserSession().getId());

        List<Cita> citas = citaService.findByEmisorId(usuario.getId());
        model.addAttribute("citas", citas);

        List<Oferta> ofertas = ofertaService.findByEmisorId(usuario.getId());
        model.addAttribute("ofertas", ofertas);
        
        List<Solicitud> solicitudes = solicitudService.findByEmisorId(Session.getUserSession().getId());
        model.addAttribute("solicitudes", solicitudes);

        List<Propiedad> propiedades = propiedadService.findAlldWithImages();
        model.addAttribute("propiedades", propiedades);

        Reclamo reclamo = new Reclamo();
        model.addAttribute("reclamos", reclamos);
        model.addAttribute("reclamo", reclamo);
        System.out.println(usuario.getNombre());

        return "profile/inquilino";
    }

    @GetMapping("/pago")
    public String pago(Model model) {

        return "pago";
    }

}
