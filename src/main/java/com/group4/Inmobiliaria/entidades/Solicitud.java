package com.group4.Inmobiliaria.entidades;

import com.group4.Inmobiliaria.enums.EstadoSolicitud;
import com.group4.Inmobiliaria.enums.TipoSolicitud;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "Solicitud")
@Getter
@Setter
@ToString
public class Solicitud extends Procedimiento implements Serializable {

    @Basic(optional = false)
    @Column(name = "Tipo_Solicitud")
    @Enumerated(EnumType.STRING)
    private TipoSolicitud tipoSolicitud;

    @Basic(optional = false)
    @Column(name = "Estado_Solicitud")
    @Enumerated(EnumType.STRING)
    private EstadoSolicitud estadoSolicitud;

}
