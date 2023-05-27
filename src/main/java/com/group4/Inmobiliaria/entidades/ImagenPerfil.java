package com.group4.Inmobiliaria.entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "Imagen_Perfil")
@Getter
@Setter
@ToString
public class ImagenPerfil extends Imagen implements Serializable {

}
