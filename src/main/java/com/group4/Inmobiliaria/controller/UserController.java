package com.group4.Inmobiliaria.controller;

import com.group4.Inmobiliaria.entidades.Admin;
import com.group4.Inmobiliaria.entidades.Cliente;
import com.group4.Inmobiliaria.entidades.Ente;
import com.group4.Inmobiliaria.entidades.Usuario;
import com.group4.Inmobiliaria.enums.TipoCliente;
import com.group4.Inmobiliaria.enums.TipoEnte;
import com.group4.Inmobiliaria.service.UserService;
import com.group4.Inmobiliaria.service.UsuarioService;
import com.group4.Inmobiliaria.utils.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Base64;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/registro")
    public String registro() {
        return "eleccionRegister";
    }

    @GetMapping("/registro/comprador")
    public String registroComprador(Cliente cliente, Model model) {
        cliente.setTipoCliente(TipoCliente.COMPRADOR);
        model.addAttribute("cliente", cliente);
        return "registerComprador";
    }

    @GetMapping("/registro/inquilino")
    public String registroInquilino(Cliente cliente, Model model) {
        cliente.setTipoCliente(TipoCliente.INQUILINO);
        model.addAttribute("cliente", cliente);
        return "registerInquilino";
    }

    @GetMapping("/registro/propietario")
    public String registroPropietario(Ente ente, Model model) {
        ente.setTipoEnte(TipoEnte.PROPIETARIO);
        model.addAttribute("ente", ente);
        return "registerPropietario";
    }

    @GetMapping("/registro/inmobiliaria")
    public String registroInmobiliaria(Ente ente, Model model) {
        ente.setTipoEnte(TipoEnte.INMOBILIARIA);
        model.addAttribute("ente", ente);
        return "registerInmobiliaria";
    }

    @PostMapping("/guardar/cliente")
    public String guardarCliente(Cliente cliente) throws Exception {
        userService.registrarCliente(cliente);
        return "redirect:/";
    }

    @PostMapping("/guardar/ente")
    public String guardarEnte(Ente ente) throws Exception {
        userService.registrarEnte(ente);
        return "redirect:/";
    }

    @PostMapping("/actualizar/cliente")
    public String actualizarCliente(Cliente cliente) throws Exception {
        userService.actualizarCliente(cliente);
        return "redirect:/";
    }

    @PostMapping("/actualizar/ente")
    public String actualizarEnte(Ente ente) throws Exception {
        userService.actualizarEnte(ente);
        return "redirect:/";
    }

    @PostMapping("/newAdmin")
    public void newAdmin(@RequestBody Admin admin) {
        userService.registrarAdmin(admin);
    }

    @GetMapping("/perfil")
    public String perfil(Model model){
        Usuario usuario = Session.getUserSession();

        try {
            byte[] imagen = usuario.getImagenPerfil().getContenido();
            String imagen64 = Base64.getEncoder().encodeToString(imagen);
            model.addAttribute("imagen64", imagen64);
        }
        catch (Exception e){
            System.out.println(e);
        }
        finally {
            model.addAttribute("usuario", usuario);
        }

        return "perfil";
    }

    @GetMapping("/modificarUsuario")
    public String modificarUsuario(Model model){
        Usuario usuario = Session.getUserSession();
        model.addAttribute("usuario", usuario);
        return "modificarUser";
    }
    @GetMapping("/modificarUsuarioA/{id}")
    public String modificarUsuarioA(@PathVariable("id") String id, Model model){
        Usuario usuario = usuarioService.findUserById(id);
        model.addAttribute("usuario", usuario);
        return "modificarUser";
    }
}



