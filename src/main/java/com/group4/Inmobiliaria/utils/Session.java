package com.group4.Inmobiliaria.utils;


import javax.servlet.http.HttpSession;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class Session {
    
    public static void setUserSession(Object user){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session = attributes.getRequest().getSession(true);
        session.setAttribute("UserSession", user);
    }
    
    public static Object getUserSession() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes != null && attributes.getRequest() != null && attributes.getRequest().getSession() != null) {
            HttpSession session = attributes.getRequest().getSession();
            return session.getAttribute("UserSession");
        }
        return null;
    }
    
    

}
