package com.group4.Inmobiliaria.entidades;

import com.group4.Inmobiliaria.enums.TipoImagenPropiedad;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "Imagen_Propiedad")
@Getter
@Setter
@ToString(callSuper = true)
public class ImagenPropiedad extends Imagen implements Serializable {

    @ManyToOne
    @JoinColumn(name = "Propiedad_Id")
    private Propiedad propiedad;

    @Basic(optional = false)
    @Column(name = "Tipo_Imagen")
    @Enumerated(EnumType.STRING)
    private TipoImagenPropiedad tipoImagenPropiedad;

}
