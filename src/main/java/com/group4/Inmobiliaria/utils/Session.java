package com.group4.Inmobiliaria.utils;

import com.group4.Inmobiliaria.entidades.Usuario;
import javax.servlet.http.HttpSession;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class Session {

    public static void setUserSession(Usuario usuario) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session = attributes.getRequest().getSession(true);
        session.setAttribute("UserSession", usuario);
    }

    public static Usuario getUserSession() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes != null && attributes.getRequest() != null && attributes.getRequest().getSession() != null) {
            HttpSession session = attributes.getRequest().getSession();
            return (Usuario) session.getAttribute("UserSession");
        }
        return null;
    }

}
