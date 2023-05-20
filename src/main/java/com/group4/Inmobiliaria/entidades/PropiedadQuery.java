package com.group4.Inmobiliaria.entidades;

public class PropiedadQuery extends Propiedad{
    @Override
    public String toString() {

        String precio= "precio:"+String.valueOf(this.getPrecioVenta()) +"\n";
        String ubicacion="ubicacion"+this.getCiudad()+"\n";
        String detalleMenor="detalle"+this.getDescripcion()+"\n";
        return precio+ubicacion+detalleMenor;
    }
}
