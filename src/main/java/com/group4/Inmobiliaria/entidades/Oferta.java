package com.group4.Inmobiliaria.entidades;

import com.group4.Inmobiliaria.enums.EstadoOferta;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "Oferta")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Oferta extends Procedimiento implements Serializable {

    @Basic(optional = false)
    @Column(name = "Estado")
    @Enumerated(EnumType.STRING)
    private EstadoOferta estado;

    @Basic(optional = false)
    @Column(name = "Monto")
    private double monto;

}
