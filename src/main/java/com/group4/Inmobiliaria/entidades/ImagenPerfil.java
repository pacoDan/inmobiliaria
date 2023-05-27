package com.group4.Inmobiliaria.entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "Imagen_Perfil")
@Getter
@Setter
@ToString
public class ImagenPerfil extends Imagen implements Serializable {

    @OneToOne(mappedBy = "imagenPerfil")
    private Usuario usuario;

}
