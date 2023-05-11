package com.group4.Inmobiliaria.domain;

public class PublicacionEjemplo {
    String titulo;

    String detallePequenio;

    int precio;

    public PublicacionEjemplo(String s, String s1, int i) {
        this.titulo = s;
        this.detallePequenio = s1;
        this.precio = i;
    }


    public String  getTitulo() {
        return this.titulo;
    }
}
